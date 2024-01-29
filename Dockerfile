FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY target/tap-backend-0.0.1-SNAPSHOT.jar tap.jar
ENTRYPOINT ["java","-jar","/tap.jar"]
