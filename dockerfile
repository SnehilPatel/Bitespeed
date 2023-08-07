
FROM maven:4.0.0-jdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY --from=build /target/BackendTask-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
