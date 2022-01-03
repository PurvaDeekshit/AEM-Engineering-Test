**Part 5: Multithreaded Int to Roman conversion + Docker**

**Steps to run:**

1) git clone https://github.com/PurvaDeekshit/AEM-Engineering-Test.git
2) cd AEM-Engineering-Test/multithreaded-int-to-roman-docker
3) mvn clean install
4) docker build -f Dockerfile -t multithreaded-docker-int-to-roman .
5) Check image generated using the command docker images
5) docker run -p 8080:8080 multithreaded-docker-int-to-roman

Test using browser:
Test url : http://localhost:8080/romannumeral?min=1&max=3

Output:
{"conversions":[{"input":"1","output":"I"},{"input":"2","output":"II"},{"input":"3","output":"III"}]}
