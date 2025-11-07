# ====== Etapa de build ======
FROM maven:3.9.9-eclipse-temurin-21 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia apenas o pom.xml primeiro (para cache das dependências)
COPY pom.xml .

# Baixa as dependências do Maven (aproveita cache)
RUN mvn dependency:go-offline -B

# Copia o restante do código-fonte
COPY src ./src

# Compila e empacota o aplicativo
RUN mvn clean package -DskipTests

# ====== Etapa de runtime ======
FROM eclipse-temurin:21-jdk

# Define diretório de trabalho da aplicação
WORKDIR /app

# Copia o .jar gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Define o comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
