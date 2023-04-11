FROM openjdk:8
WORKDIR /workspace
COPY ./target/cloud-server.jar /workspace/cloud-server.jar
CMD ["ls"]
ENTRYPOINT ["java","-jar","cloud-server.jar"]
EXPOSE 6671