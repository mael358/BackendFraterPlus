# Usar una imagen base de OpenJDK 21
FROM openjdk:21-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el JAR generado al directorio de trabajo
COPY build/libs/back-end-spring-rest-1.0.0.jar FraterPlusBackend.jar

# Exponer el puerto en el que se ejecuta la aplicación
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "FraterPlusBackend.jar"]
