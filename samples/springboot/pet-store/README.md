
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

# Limitations
- Must use maven shade plugin, and not the spring boot plugin, due to SAM local dependency issues.


