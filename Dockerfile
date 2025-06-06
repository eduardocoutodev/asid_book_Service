FROM maven:3.9.2-eclipse-temurin-17 AS build

WORKDIR /app

COPY . .

# Compila o projeto sem correr os testes
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia o ficheiro jar gerado na etapa de build
COPY --from=build /app/target/*.jar book-service.jar

# Define o comando de arranque
ENTRYPOINT ["java", "-jar", "book-service.jar"]
