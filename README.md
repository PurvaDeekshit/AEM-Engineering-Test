# AEM-Engineering-Test

I have used JAVA and Sprinboot framework for this project.

To add DevOps capabilities to the project, I have used the following CNCF suggested tools since they are CNCF graduated projects described on the CNCF landscape webpage: https://landscape.cncf.io/.

a) Prometheus and Grafana

b) Jaeger

c) Elasticsearch, Fluentd and Kibana (EFK) Stack

**Project info:**

There are total 5 projects in this repository:
1. int-to-roman-docker
 
   Exposed REST API endpoint: "http://localhost:8080/romannumeral?query={integer}". Each Request generated unique UUID.
   
   Used Actuator endpoints let you monitor and interact with your application.
   
   Dockerized JAVA application using openjdk.
   
   Generated SwAgger API Documention using OpenAPI (springdoc-openapi plugin).
   
2. prometheus-grafana-integration
   
   Integrated Prometheus and Grafana for metrics info and monitoring.
   
   Dockerized JAVA application using openjdk. Prometheus and Grafana run in their respective containers.

3. jaeger-integration

   Integrated Jaeger for dstributed tracing of requests.
   
   Jaeger runs in its own container.

4. efk-integration
  
   Integrated Elasticsearch, Fluentd and Kibana (EFK) Logging Stack. 
   
   Dockerized JAVA application using openjdk. Elasticsearch, Fluentd and Kibana each have their own containers.

5. multithreaded-int-to-roman-docker

   Added support for range queries and exposed REST API endpoint: "http://localhost:8080/romannumeral?min={integer}&max={integer}"
   
   Used Java ExecutorService to create a fixed threadpool to convert the range of integers to roman numerals using mutliple threads.
   
   Dockerized JAVA application using openjdk.

Each project has its own README.md file with steps to pull and run the source code.

**Engineering and testing methodology:**

Used JAVA SpringBoot framework to develop REST endpoints.

Used Actuator endpoints to monitor and interact with the application and maven for project build.  

Followed Test-driven development methodology.

Developed Junit test cases for service layer and REST controller.

**Packaging Layout:**

-- src/main:

    -- controller
   
       exposes the REST APIs and calls the service layer. 
       
    -- service 
   
       contains the business logic to invoke each subpart and return a success/failure response to the controller.
       
    -- entity
   
       contains the logic to validate input and give roman output.
    
-- src/test:

    -- controller
   
       contains the JUNIT tests for testing REST endpoints.
       
    -- entity
   
       contains the JUNIT tests for validating the core functionality.
       
-- pom.xml contains the project dependencies.

-- Dockerfile contains the steps to build docker image.

**Project structure:**

![image](https://user-images.githubusercontent.com/47338443/147909114-886e3f09-f8de-4964-901c-0e131d288379.png)

**Dependency Attribution:**

Maven - project build and dependency management

Dependencies in pom.xml:

spring-boot-starter-web - Starter for building RESTful services

spring-boot-starter-test - Starter for testing Spring Boot applications with libraries including JUnit Jupiter, Hamcrest and Mockito

springdoc-openapi-ui - For generation of API documentation

spring-boot-starter-actuator - Starter for using Spring Boot’s Actuator for metrics and monitoring

micrometer-registry-prometheus - For Prometheus monitoring

opentracing-spring-jaeger-web-starter - For Jaeger distributed tracing

More details in attached report.

**Tests:**

Controller test:

validInput - test covering positive scenario, where input is integer within the specified range.

invalidInput - test covering a scenario, where input is not integer.

outOfRangeInputBelowMinimumValue - test covering a scenario, where input is less than the specified range.

outOfRangeInputAboveMaximumValue - test covering a scenario, where input is greater than the specified range.

Functionality test:

testValidInput - test if input parameter can be converted to integer.

testInvalidInput - test if input parameter cannot be converted to integer.

testValidInputRange -  test if input is in the specified range.

testInvalidInputRange - test if input is not in the specified range.

testGetRoman - test if the input is converted to roman numeral correctly.

**Error Handling:**
