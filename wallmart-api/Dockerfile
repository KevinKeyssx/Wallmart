FROM openjdk:17-jdk-alpine
LABEL maintainer="Kevin Candia @kevinkeyssx build api"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8030
ENTRYPOINT ["java","-jar","/app.jar"]