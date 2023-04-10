FROM maven:3.6.3-openjdk-8 as builder
WORKDIR /tmp/workspace
COPY ./ /tmp/workspace
CMD mvn clean package


FROM openjdk:8-jre
WORKDIR /workspace
ADD cloud-server.jar cloud-server.jar
CMD java -jar /workspace/cloud-server.jar
EXPOSE 6670