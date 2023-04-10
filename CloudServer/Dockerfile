FROM maven:3.6.3-openjdk-8 as builder
WORKDIR /tmp/workspace
COPY src/main/java /tmp/workspace
RUN mvn clean package\
    echo "打包完成"


FROM openjdk:8-jre
WORKDIR /workspace
COPY --from=builder /tmp/workspace/target/cloud-server.jar /workspacr/cloud-server.jar
CMD java -jar /workspace/cloud-server.jar
EXPOSE 6670