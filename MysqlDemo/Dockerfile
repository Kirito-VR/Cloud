FROM ubuntu:latest
WORKDIR /workspace

COPY ./target/mysql-server.jar /workspace/app.jar
CMD ["java","-jar","app.jar"]
EXPOSE 6667