# ====== Build (JDK 8) ======
FROM maven:3.9.6-eclipse-temurin-8 AS build
WORKDIR /app
COPY . .
RUN mvn -DskipTests package

# ====== Runtime (JRE 8) ======
FROM openjdk:8-jre-slim
WORKDIR /app
COPY --from=build /app/target/shape_v-1.0-SNAPSHOT.jar app.jar

# Koyeb define a porta em $PORT
ENV PORT=8080
EXPOSE 8080

# Limites mais modestos pra Free Instance
ENV JAVA_TOOL_OPTIONS="-Xms128m -Xmx384m -XX:+UseContainerSupport"

CMD ["sh", "-c", "java -Dserver.port=$PORT -jar app.jar"]
