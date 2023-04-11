FROM openjdk:8
WORKDIR /workspace
COPY ./target/mongo-server.jar /workspace/mongo-server.jar
CMD ["java","-jar","mongo-server.jar"]
EXPOSE 6666