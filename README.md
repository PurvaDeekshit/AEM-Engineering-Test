# AEM-Engineering-Test

There are total 5 projects in this repository:
1. int-to-roman-docker
 
   Exposes REST API Endpoint : "http://localhost:8080/romannumeral?query={integer}"
   
   Used Actuator endpoints let you monitor and interact with your application.
   
   Dockerized JAVA application using openjdk
   
2. prometheus-grafana-integration
   
   Integrated Prometheus and Grafana for metrics info and monitoring

3. jaeger-integration

   Integrated Jaeger for dstributed tracing of requests

4. efk-integration
  
   Integrated Elasticsearch, Fluentd and Kibana (EFK) Logging Stack

5. multithreaded-int-to-roman-docker

   Added support for range queries REST enpoint : "http://localhost:8080/romannumeral?min={integer}&max={integer}"
   Used Java ExecutorService to create fixed thread pool to convert range of integers to roman numerals using mutliple threads.

Each project has its own README.md file with steps to pull and run the source code.

Engineering and testing methodology:
Used JAVA SpringBoot framework to develop REST endpoints. Used Actuator endpoints let you monitor and interact with your application.
Used maven for project build.  
Followed Test-driven development methodology. Developed Junit test cases for service layer and REST controller.

Packaging layout: Details in attached report. 

Dependency attribution: Details in attached report. 
