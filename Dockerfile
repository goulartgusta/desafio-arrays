# Usando OpenJDK para compilar e rodar a aplicação
FROM openjdk:21-jdk-slim

# Diretório do container
WORKDIR /app

# Copiar arquivos para o container
COPY target/meu-projeto-1.0.0.jar app.jar

# Comando para rodar o jar
CMD ["java", "-jar", "app.jar"]