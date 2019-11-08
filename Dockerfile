FROM openjdk:8-jre-alpine
RUN mkdir -p /opt/SimpleWeb
WORKDIR /opt/SimpleWeb
COPY target/SimpleWeb-0.0.1-SNAPSHOT.jar /opt/SimpleWeb
CMD ["java", "-jar", "SimpleWeb-0.0.1-SNAPSHOT.jar"]
