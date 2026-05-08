# Imagen base con Java 21
FROM eclipse-temurin:21-jdk

# Directorio de trabajo
WORKDIR /app

# Copiar el jar generado
COPY target/app.jar app.jar

# Puerto (opcional si es API)
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]