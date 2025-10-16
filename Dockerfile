# ====== Etapa de build ======
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn -DskipTests package

# ====== Etapa de runtime (leve) ======
FROM eclipse-temurin:17-jre
WORKDIR /app
# copia o JAR gerado (qualquer nome) para app.jar
COPY --from=build /app/target/*.jar app.jar

# Koyeb injeta a porta em $PORT
ENV PORT=8080
EXPOSE 8080

# memória mais contida para Free Instance
ENV JAVA_TOOL_OPTIONS="-Xms128m -Xmx384m -XX:+UseContainerSupport"

# Start
CMD ["sh","-c","java -Dserver.port=$PORT -jar app.jar"]
