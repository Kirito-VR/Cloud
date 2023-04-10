FROM maven:3.63-openjdk-8 as builder
WORKDIR /tmp/workspace
COPY ./ /tmp/workspace
RUN --mount=type=cache.target=/root/.m2 mvn clean package


FROM openjdk:8
WORKDIR /workspace
COPY --from=builder /tmp/workspace/target/cloud-server.jar /workspacr/cloud-server.jar
CMD java -jar /workspace/cloud-server.jar
EXPOSE 6670