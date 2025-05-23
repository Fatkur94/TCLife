package com.techcombank.tclife.authService.service;

import com.techcombank.tclife.authService.model.request.LoginRequest;
import com.techcombank.tclife.authService.model.request.RegisterRequest;
import com.techcombank.tclife.authService.model.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CognitoService {

    @Value("${aws.cognito.userPoolId}")
    private String userPoolId;

    @Value("${aws.cognito.clientId}")
    private String clientId;

    @Value("${aws.cognito.region}")
    private String region;

    public boolean registerUser(RegisterRequest request) {
        try (CognitoIdentityProviderClient client = CognitoIdentityProviderClient.builder().region(Region.of(region)).build()) {

            List<AttributeType> attributes = List.of(
                    AttributeType.builder().name("email").value(request.email).build(),
                    AttributeType.builder().name("custom:userType").value(request.userType).build()
            );

            AdminCreateUserRequest createUserRequest = AdminCreateUserRequest.builder()
                    .userPoolId(userPoolId)
                    .username(request.email)
                    .temporaryPassword(request.password)
                    .userAttributes(attributes)
                    .desiredDeliveryMediums(DeliveryMediumType.EMAIL)
                    .build();

            client.adminCreateUser(createUserRequest);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public AuthResponse loginUser(LoginRequest request) {
        try (CognitoIdentityProviderClient client = CognitoIdentityProviderClient.builder().region(Region.of(region)).build()) {

            AdminInitiateAuthRequest authRequest = AdminInitiateAuthRequest.builder()
                    .authFlow(AuthFlowType.ADMIN_NO_SRP_AUTH)
                    .clientId(clientId)
                    .userPoolId(userPoolId)
                    .authParameters(
                            java.util.Map.of("USERNAME", request.email, "PASSWORD", request.password)
                    )
                    .build();

            AdminInitiateAuthResponse authResponse = client.adminInitiateAuth(authRequest);

            if (ChallengeNameType.NEW_PASSWORD_REQUIRED.toString().equals(authResponse.challengeNameAsString())) {
                if (request.newPassword == null || request.newPassword.isEmpty()) {
                    return new AuthResponse(false, "NEW_PASSWORD_REQUIRED", null, true);
                }

                AdminRespondToAuthChallengeRequest challengeRequest = AdminRespondToAuthChallengeRequest.builder()
                        .challengeName(ChallengeNameType.NEW_PASSWORD_REQUIRED)
                        .clientId(clientId)
                        .userPoolId(userPoolId)
                        .challengeResponses(java.util.Map.of(
                                "USERNAME", request.email,
                                "NEW_PASSWORD", request.newPassword
                        ))
                        .session(authResponse.session())
                        .build();

                AdminRespondToAuthChallengeResponse challengeResponse = client.adminRespondToAuthChallenge(challengeRequest);
                return new AuthResponse(true, "Login successful (after password change)", challengeResponse.authenticationResult().idToken(), false);
            }

            return new AuthResponse(true, "Login successful", authResponse.authenticationResult().idToken(), false);

        } catch (Exception e) {
            return new AuthResponse(false, "Login failed: " + e.getMessage(), null, false);
        }
    }
}

