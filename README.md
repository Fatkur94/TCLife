# Microservice Archetype
This archetype is to be used as a base template to start Microservice development, it contains Spring boot dependencies, and Spring Cloud Stack.

## Prerequisite
1. Java 21
2. Maven
3. Redis
4. PostgreSQL

## Getting Started
#### Project Structure
| Component  | Description                                                                     | 
|------------|---------------------------------------------------------------------------------|
| Controller | Define URL, Http Method and requests for incoming API of the Microservice.      |
| Service    | Contain business logic for the API.                                             |
| Repository | Layer to communicate to Database with JPA library.                              |
| Client     | Integration layer with other Microservice and external system with FeignClient. |

#### Configuration
Contains common configuration for:
1. Outbound Client
2. Common Configuration (Error Handling)

## How To Use
#### 1. Compiling Microservice Archetype locally
1. Navigate to microservices project
    ```command 
    cd TCLife/<project>
    ```
   Make sure that `<project-root-directory>/target` folder is generated.

2. Install Archetype to Maven Internal Catalog
    ```command
    mvn clean install      
    ```

   Make sure that File `$MAVEN_HOME/repository/archetype-catalog.xml` is generated.

4. Run Microservices Archtype
    ```command
    mvn spring-boot:run    
    ```

#### 2. Deploy Microservice Archetype to Remote Repository
1. Navigate to project Directory
    ```command
    cd project/target/
    ```  

2. Ensure that pom file is present in the target\...\pom.xml
3. Run Deploy Command
   ```command
    mvn clean deploy
   ```
## Project Configuration
##### Spring Profiles

There are 1 Spring profiles supported at this moment:
1. dev
