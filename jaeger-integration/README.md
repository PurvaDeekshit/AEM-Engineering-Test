Part 3: Tracing using Jaeger

Add dependency in pom.xml
<dependency>
	<groupId>io.opentracing.contrib</groupId>
	<artifactId>opentracing-spring-jaeger-web-starter</artifactId>
	<version>3.3.1</version>
</dependency>

Create JaegerConfig.java file.

Steps:

1) mvn clean install

2) Run Jaeger in docker
docker run -d --name jaeger-ui -p 16686:16686 -p 6831:6831/udp jaegertracing/all-in-one
 
3) Run application using
java -jar target/docker-int-to-roman-0.0.1-SNAPSHOT.jar

4) Check Jaeger URL:
http://localhost:16686/
