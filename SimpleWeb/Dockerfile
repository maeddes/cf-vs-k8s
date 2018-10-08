FROM openjdk:8-alpine
RUN mkdir -p /opt/SimpleWeb
WORKDIR /opt/SimpleWeb
COPY target/SimpleWeb-0.0.1-SNAPSHOT.jar /opt/SimpleWeb
CMD ["java", "-Dspring.profiles.active=k8s", "-jar", "SimpleWeb-0.0.1-SNAPSHOT.jar"]
