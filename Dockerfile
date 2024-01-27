FROM maven:3.8.4-openjdk-11-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean install

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/your-artifact-id.jar ./app.jar
CMD ["java", "-jar", "app.jar"]
