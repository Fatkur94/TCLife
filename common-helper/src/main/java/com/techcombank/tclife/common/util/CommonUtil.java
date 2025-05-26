package com.techcombank.tclife.common.util;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

public class CommonUtil {

    private CommonUtil() {
    }

    public static String generateUUIDString() {
        return UUID.randomUUID().toString();
    }

    public String generateSecureToken(int byteLength) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[byteLength];
        secureRandom.nextBytes(token);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token);
    }

    public static String generateContextToken() {
        return generateSecureToken(256);
    }

}
