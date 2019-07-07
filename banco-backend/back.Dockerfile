# Base Java runtime image
FROM openjdk:12-alpine

LABEL MAINTAINER mauricio.acevedo@gmail.com

ARG JAR_FILE=target/banco-backend-demo.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080