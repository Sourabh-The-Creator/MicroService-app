FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/order-0.0.1.jar app.jar
EXPOSE 8081
CMD ["java", "-jar", "app.jar"]
