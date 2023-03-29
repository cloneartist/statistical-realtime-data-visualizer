FROM openjdk:17-jdk-slim
WORKDIR usr/src
ADD ./target/webapp-0.0.1-SNAPSHOT.jar /usr/src/webapp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","webapp-0.0.1-SNAPSHOT.jar"]