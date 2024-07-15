# Use the appropriate base image for JDK 11 on Windows
FROM java:11

# Expose port 8080
EXPOSE 8082

ADD target/spring-boot-blog-app.jar spring-boot-blog-app.jar 
# Set the environment variable for the application home directory

# Copy the JAR file into the container

# Set the working directory

# Specify the entrypoint command to run the application
ENTRYPOINT ["java", "-jar", "spring-boot-blog-app.jar"]
