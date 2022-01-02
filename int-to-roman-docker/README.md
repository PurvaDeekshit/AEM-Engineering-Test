Part 1: Integer to Roman conversion:
========

Introduction:



Steps to run:

1) git clone https://github.com/PurvaDeekshit/AEM-Engineering-Test.git
2) cd AEM-Engineering-Test/int-to-roman-docker
3) mvn clean install
4) “docker build -f Dockerfile -t docker-int-to-roman .”
5) Check image generated using “docker images”
5) “docker run -p 8080:8080 docker-int-to-roman”

API Documentation : http://localhost:8080/swagger-ui.html


Test using browser:
Test url : http://localhost:8080/romannumeral?query=10
Output: 
{"input":10,"output":"X"}
Code details :
Controller
Service
Entity
Tests

Code details:

Test details:

Structure:




