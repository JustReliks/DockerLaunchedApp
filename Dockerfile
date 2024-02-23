FROM maven:3.9.4-eclipse-temurin-17 as build


COPY src src
COPY pom.xml pom.xml

RUN mvn clean package

FROM openjdk:17-jdk-alpine

RUN adduser --system docker-app && addgroup --system docker-app && adduser docker-app docker-app
USER docker-app

WORKDIR /app

COPY --from=build target/DockerApp.jar ./docker-app.jar
COPY --from=build target/dependency ./lib

ENTRYPOINT ["java", "-cp", "./lib/*:./docker-app.jar", "org/dockerlaunched/DockerLaunchedApplication"]