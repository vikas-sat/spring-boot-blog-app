FROM maven:3.13.0-jdk-11-slim AS build  
WORKDIR /app
COPY src /usr/src/app/src  
COPY pom.xml .
RUN mvn dependency:go-offline
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8081
CMD ["java", "-jar", "app.jar"]


