FROM openjdk:17
VOLUME /tmp
ADD target/SpringBootApp-0.0.1-SNAPSHOT.jar spring-boot-example.jar
EXPOSE 8085
ENTRYPOINT [ "java" , "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005" , "-jar" , "spring-boot-example.jar"]