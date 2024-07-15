# Use the appropriate base image for JDK 11 on Windows
FROM openjdk:11-windowsservercore

# Expose port 8080
EXPOSE 8080

# Set the environment variable for the application home directory
ENV APP_HOME C:\\usr\\src\\app

# Copy the JAR file into the container
COPY target\\secretsanta-0.0.1-SNAPSHOT.jar $APP_HOME\\app.jar

# Set the working directory
WORKDIR $APP_HOME

# Specify the entrypoint command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
