FROM openjdk:17-jdk-slim
WORKDIR usr/src
ADD ./target/data-analytics-service-0.0.1-SNAPSHOT.jar /usr/src/data-analytics-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","data-analytics-service-0.0.1-SNAPSHOT.jar"]