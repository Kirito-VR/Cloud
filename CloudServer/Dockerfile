FROM openjdk:8
WORKDIR /workspace
COPY ./target/cloud-server.jar /workspacr/cloud-server.jar
ENTRYPOINT ["java","-jar","redis-server.jar"]
EXPOSE 6671