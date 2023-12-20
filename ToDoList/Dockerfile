# Use a base image with JDK and Maven installed
FROM maven:3-eclipse-temurin-21 AS build
WORKDIR /app

# Copy the POM file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the application source code
COPY src ./src

# Build the application
RUN mvn package -Dmaven.test.skip

# Use a lighter base image for runtime
FROM eclipse-temurin:21-alpine

WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/todolist-1.0.0-SNAPSHOT.war ./app.war

EXPOSE 8080

# Set the default command to run your application
CMD ["java", "-jar", "app.war"]