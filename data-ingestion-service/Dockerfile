FROM openjdk:17-jdk-slim
WORKDIR usr/src
ADD ./target/data-ingestion-service-0.0.1-SNAPSHOT.jar /usr/src/data-ingestion-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","data-ingestion-service-0.0.1-SNAPSHOT.jar"]