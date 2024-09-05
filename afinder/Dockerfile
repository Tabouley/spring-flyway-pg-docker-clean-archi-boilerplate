FROM amazoncorretto:21
WORKDIR /app
COPY build/libs/*.jar app.jar
EXPOSE 8080

# Commande pour exécuter l'application Spring Boot
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
