FROM maven:3.8.4-openjdk-11-slim AS build
EXPOSE 8081
ENV APP_HOME
COPY target/spring-boot-blog-app-0.0.1-SNAPSHOT.jar $APP_HOME/app.jar
WORKDIR $APP_HOME
ENTRYPOINT exec java -jar app.jar
