FROM openjdk:17
VOLUME /tmp
EXPOSE 443
COPY target/tap-backend-0.0.1-SNAPSHOT.jar tap.jar
ENTRYPOINT ["java","-jar","/tap.jar"]
