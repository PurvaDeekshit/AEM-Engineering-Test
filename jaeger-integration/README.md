**Part 3: Tracing using Jaeger**

1. Add the following dependency in pom.xml file:
<dependency>
	<groupId>io.opentracing.contrib</groupId>
	<artifactId>opentracing-spring-jaeger-web-starter</artifactId>
	<version>3.3.1</version>
</dependency>

2. Create a JaegerConfig.java file, so that Jaeger can trace the incoming requests.

**Steps to run:**

1) mvn clean install
2) Run Jaeger in docker using the command:
docker run -d --name jaeger-ui -p 16686:16686 -p 6831:6831/udp jaegertracing/all-in-one 
3) Run the application using the command:
java -jar target/docker-int-to-roman-0.0.1-SNAPSHOT.jar
4) Check the Jaeger URL: http://localhost:16686/
5) Under the “Service” section, click on “int-to-roman” and click on “Find Traces”. Refresh the page if the service is not visible.
6) The tracing logs can be viewed in detail under the “Service & Operation” section.
