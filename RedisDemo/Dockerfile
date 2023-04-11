FROM openjdk:8
WORKDIR /workspace
COPY ./target/redis-server.jar /workspace/redis-server.jar
ENTRYPOINT ["java","-jar","redis-server.jar"]
EXPOSE 6671