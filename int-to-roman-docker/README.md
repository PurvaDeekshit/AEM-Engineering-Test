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
