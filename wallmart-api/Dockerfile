# FROM openjdk:17-jdk-alpine
# LABEL maintainer="Kevin Candia @kevinkeyssx por dentro"
# COPY target/*.jar /app.jar
# # COPY wallmart-api/target/*.jar /app.jar
# EXPOSE 8030
# ENTRYPOINT ["java", "-jar", "app.jar"]

# FROM maven:3.6.0-jdk-17-alpine AS build
# COPY src /home/app/src
# COPY pom.xml /home/app
# RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17-jdk-alpine
LABEL maintainer="Kevin Candia @kevinkeyssx"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8030
ENTRYPOINT ["java","-jar","/app.jar"]