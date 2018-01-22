
# AWS Lambda Serverless Spring Boot Application

- $ cd $HOME
- $ git clone git://github.com/quantum-fusion/aws-serverless-java-container.git
- $ cd aws-serverless-java-container/
- $ mvn clean install
- $ cd samples/springboot/pet-store
- $ mvn package

# Run Sam Local for Lambda Proxy local testing

- $sam local start-api --template sam.yaml


# REST API Tests

- $ curl 127.0.0.1:3000/pets
- $ curl 127.0.0.1:3000/helloworld
- $ curl 127.0.0.1:3000/restaurant/helloworld

Databases Supported:
- Cassandra (https://github.com/quantum-fusion/aws-serverless-java-container/blob/master/samples/springboot/pet-store/src/main/java/com/server/springboot/cassandra/SessionUtil.java)
- DynamoDb (http://www.baeldung.com/spring-data-dynamodb)

# Limitations
- Must use maven shade plugin, and not the spring boot plugin, due to SAM local dependency issues.

# See Spring-Boot with Swagger2 REST Controller compared to Lambda without Swagger2 REST Controller.
- Lambda REST Controller without Swagger2 (https://github.com/quantum-fusion/aws-serverless-java-container/blob/master/samples/springboot/pet-store/src/main/java/com/server/springboot/controller/RestaurantController.java)
- Spring-Boot with Swagger2 without Lambda (https://github.com/quantum-fusion/springboot_swagger_example-master-cassandra/blob/master/src/main/java/com/server/springboot/controller/RestaurantController.java)

# See Lambda Sam local Petstore example controller
- (https://github.com/quantum-fusion/aws-serverless-java-container/blob/master/samples/springboot/pet-store/src/main/java/com/server/springboot/controller/PetsController.java)


