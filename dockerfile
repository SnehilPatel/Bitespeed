

#
# Build stage
#
FROM maven:4.0.0-jdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ./target/BackendTask-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]