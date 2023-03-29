FROM openjdk:17-jdk-slim
WORKDIR usr/src
ADD ./target/data-streaming-service-0.0.1-SNAPSHOT.jar /usr/src/data-streaming-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","data-streaming-service-0.0.1-SNAPSHOT.jar"]