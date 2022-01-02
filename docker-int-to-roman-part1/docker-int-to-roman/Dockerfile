FROM openjdk:17
ADD target/docker-int-to-roman-0.0.1-SNAPSHOT.jar docker-int-to-roman.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-int-to-roman.jar"]