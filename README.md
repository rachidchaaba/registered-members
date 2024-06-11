# Registred members

This application aims to uniquely number the company registered members.

## Installation
To compile and test : `mvn clean verify`

To compile, test and install the application : `mvn clean install`

To run the application : `mvn spring-boot:run`

The application runs by default on the port : `8080` with the context-path `/`

## Automated Integration tests
The integration tests are implemented using cucubmer and junit5.

To launch the cucumber tests :
- Using intellij IDE, open the class CucumberRunnerTest, right click and the click on Run.
- Using maven: mvn test -Dtest=CucumberRunnerTest

## CURL to test on postman
The following are some curls to set the config, get the config and generate registered member number.
- GET CONFIG:
  ```
  curl --location 'http://localhost:8080/config'
  ```

- PUT CONFIG
  ```
  curl --location --request PUT 'http://localhost:8080/config' \
  --header 'Content-Type: application/json' \
  --data '{
  "firstNameConfig": {
  "suffix": "-",
  "length": 3,
  "index": 1
  },
  "lastNameConfig": {
  "suffix": "_",
  "length": 4,
  "index": 2
  },
  "birthDateConfig": {
  "pattern": "YYYY",
  "index": 3
  },
  "counterConfig": {
  "prefix": "C",
  "numberOfDigits": 5,
  "value": 10,
  "index": 4
  }
  }'
  ```
  
- GENERATE NUMBER
``` 
curl --location 'http://localhost:8080/registration' \
  --header 'Content-Type: application/json' \
  --data '{
  "firstName": "Marc",
  "lastName": "PASSAU",
  "birthDate": "24/04/1974"
  }'
  ```