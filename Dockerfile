# Stage 1: Build
# FROM maven:3.9.3-eclipse-temurin-20 AS build
# WORKDIR /app
# COPY pom.xml .
# COPY src ./src
# RUN mvn clean package -DskipTests

# Stage 2: Run
# FROM eclipse-temurin:21-jre-alpine
# WORKDIR /app
# COPY --from=build /app/target/feedback-analytics-consumer-0.0.1-SNAPSHOT.jar app.jar
# ENTRYPOINT ["java","-jar","app.jar"]


# ---- Build Stage ----
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .

# Make mvnw executable if using wrapper
RUN chmod +x ./mvnw

# Build the project
RUN ./mvnw -q -DskipTests package

# ---- Run Stage ----
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
