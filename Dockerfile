
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
