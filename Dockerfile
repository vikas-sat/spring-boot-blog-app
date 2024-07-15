FROM maven:3.8.4-openjdk-11-slim AS build
EXPOSE 8081

# Define the environment variable with a value
ENV APP_HOME /usr/app

# Copy the JAR file to the defined APP_HOME
COPY target/spring-boot-blog-app.jar $APP_HOME/app.jar

# Set the working directory to APP_HOME
WORKDIR $APP_HOME

# Run the application
CMD ["java", "-jar", "app.jar"]
