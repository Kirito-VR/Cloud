FROM maven:3.63-openjdk-8 as builder
WORKDIR /tmp/workspace
COPY src/main/resources /tmp/workspace
RUN --mount=type=cache.target=/root/.m2 mvn clean package



FROM openjdk:8
WORKDIR /workspace
COPY --from=builder /tmp/workspace/target/redis-server.jar /workspacr/redis-server.jar
CMD java -jar /workspace/redis-server.jar
EXPOSE 6671