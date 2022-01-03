# AEM-Engineering-Test

**Integer to Roman Numeral conversion + Docker**

This project is developed using JAVA (version 17) and Sprinboot framework. I initialized the project using springboot initializr: https://start.spring.io/

To add DevOps capabilities to the project, I have used the following CNCF suggested tools since they are CNCF graduated projects described on the CNCF landscape webpage: https://landscape.cncf.io/.

1. Prometheus and Grafana

2. Jaeger

3. Elasticsearch, Fluentd and Kibana (EFK) Stack

**Project info:**

There are total 5 projects in this repository. Each project has its own README.md file with steps to pull and run the source code.

1. int-to-roman-docker
 
   Exposed REST API endpoint: "http://localhost:8080/romannumeral?query={integer}". Each request generated an unique UUID.
   
   Used Actuator endpoints to monitor and interact with the application.
   
   Dockerized JAVA application using openjdk.
   
   Generated Swagger API Documention using OpenAPI (springdoc-openapi plugin).

   JUnit testcase for controller and functional testing.
   
2. prometheus-grafana-integration
   
   Integrated Prometheus and Grafana for metrics info and monitoring.
   
   Dockerized JAVA application using openjdk. Prometheus and Grafana run in their respective containers.

3. jaeger-integration

   Integrated Jaeger for dstributed tracing of requests.
   
   Jaeger runs in its own container.

4. efk-integration
  
   Integrated Elasticsearch, Fluentd and Kibana (EFK) Logging Stack.
   
   Application running at 8080 sends logs to Fluentd using the Fluentd logging driver.
   
   Fluentd fowrwards these to Elasticsearch. Kibana pulls these logs from Elasticsearch.
   
   Created index pattern for logs.
   
   Dockerized JAVA application using openjdk. Elasticsearch, Fluentd and Kibana each have their own containers.

5. multithreaded-int-to-roman-docker

   Added support for range queries and exposed REST API endpoint: "http://localhost:8080/romannumeral?min={integer}&max={integer}"
   
   Used Java ExecutorService to create a fixed threadpool to convert the range of integers to roman numerals using mutliple threads.
   
   Dockerized JAVA application using openjdk.

**Engineering and Testing methodology:**

Used JAVA SpringBoot framework to develop REST endpoints. Structured code as controller, service and entity layers.

Used Actuator endpoints to monitor and interact with the application and maven for project build.  

Followed Test-driven development methodology.

Developed Junit test cases for service layer and REST controller.

**Packaging layout:**

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

**Dependency attribution:**

Maven - project build and dependency management

Dependencies in pom.xml:

spring-boot-starter-web - Starter for building RESTful services

spring-boot-starter-test - Starter for testing Spring Boot applications with libraries including JUnit Jupiter, Hamcrest and Mockito

springdoc-openapi-ui - For generation of API documentation

spring-boot-starter-actuator - Starter for using Spring Boot’s Actuator for metrics and monitoring

micrometer-registry-prometheus - For Prometheus monitoring

opentracing-spring-jaeger-web-starter - For Jaeger distributed tracing

**Tests:**

Performed testing using Postman and manual testing in the browser using the URL.

Used JUnit Test for the following tests:

1. Controller test:

1.1. validInput - test covering positive scenario, where input is integer within the specified range.

1.2. invalidInput - test covering a scenario, where input is not integer.

1.3. outOfRangeInputBelowMinimumValue - test covering a scenario, where input is less than the specified range.

1.4. outOfRangeInputAboveMaximumValue - test covering a scenario, where input is greater than the specified range.

2. Functionality test:

2.1 testValidInput - test if input parameter can be converted to integer.

2.2 testInvalidInput - test if input parameter cannot be converted to integer.

2.3 testValidInputRange -  test if input is in the specified range.

2.4 testInvalidInputRange - test if input is not in the specified range.

2.5 testGetRoman - test if the input is converted to roman numeral correctly.

**Error handling:**

Following scenarios are handled in the service and functional layer code. These errors are returned in plain text format.

1. If input is not a positive integer - "Invalid input specified"

2. If input is within the specified range - "Invalid Input Range"

3. If input is null - "Null received while converting integer to roman"

4. If input is empty - "Empty string received while converting integer to roman"

5. If minimum number is not less than maximum number - "Min number is greater than or equal to Max number"

**References:**

1. Specification for Roman numerals: https://en.wikipedia.org/wiki/Roman_numerals

2. Spring Boot: https://start.spring.io/

3. Junit: https://spring.io/guides/gs/testing-web/

4. Maven: https://docs.spring.io/spring-android/docs/2.0.0.M3/reference/html/maven.html

5. OpenAPI documentation: https://springdoc.org/

6. Prometheus: https://prometheus.io/docs/prometheus/latest/getting_started/

7. Grafana: https://grafana.com/docs/grafana/latest/getting-started/

8. Fluentd: https://docs.fluentd.org/quickstart

9. Elasticsearch: https://www.elastic.co/guide/en/elastic-stack-get-started/current/index.html

10. Kibana: https://www.elastic.co/guide/en/kibana/current/index.html

11. Jaeger: https://www.jaegertracing.io/docs/1.29/getting-started/

More details in the attached report.
