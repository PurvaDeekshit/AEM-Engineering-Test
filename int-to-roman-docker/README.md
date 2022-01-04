**Part 1: Integer to Roman Numeral conversion and Docker container**

**Steps to run:**

1) git clone https://github.com/PurvaDeekshit/AEM-Engineering-Test.git
2) cd AEM-Engineering-Test/int-to-roman-docker
3) mvn clean install
4) docker build -f Dockerfile -t docker-int-to-roman .
5) Check image generated using the command docker images
6) docker run -p 8080:8080 docker-int-to-roman
7) check API documentation: http://localhost:8080/swagger-ui.html

Test using browser:

Test url:

http://localhost:8080/romannumeral?query=10

Output:

{
"input":10,"output":"X"
}

**Sample output from Swagger OpenAPI documentation:**

![image](https://user-images.githubusercontent.com/47338443/148022537-bc4f661c-0387-4700-bf02-95e419f7fcfb.png)

![image](https://user-images.githubusercontent.com/47338443/148022629-d09f2411-b0f5-47ac-90d2-39b2ce070b46.png)

