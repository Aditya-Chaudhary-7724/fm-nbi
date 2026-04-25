FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

EXPOSE 10000

CMD ["java", "-jar", "target/fm-nbi-0.0.1-SNAPSHOT.jar"]