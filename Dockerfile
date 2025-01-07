FROM maven:3.9.9-eclipse-temurin-21

WORKDIR /app

COPY pom.xml /app
RUN mvn dependency:resolve

COPY src /app/src

CMD ["mvn", "test"]