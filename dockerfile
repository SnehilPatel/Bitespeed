FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ./target/BackendTask-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]