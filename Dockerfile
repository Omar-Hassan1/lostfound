FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . .
RUN chmod +x mvnw && ./mvnw package
CMD ["java", "-jar", "target/lostfound-0.0.1-SNAPSHOT.jar"]
