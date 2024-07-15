FROM maven:3.8.4-openjdk-11-slim AS build
EXPOSE 8081
ENV APP_HOME
COPY target/spring-boot-blog-app-0.0.1-SNAPSHOT.jar $APP_HOME

WORKDIR /app
COPY src /usr/src/app/src  
COPY pom.xml .
RUN mvn dependency:go-offline
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
CMD ["java", "-jar", "spring-boot-blog-app-0.0.1-SNAPSHOT.jar"]


