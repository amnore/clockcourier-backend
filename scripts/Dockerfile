FROM openjdk:11

VOLUME /logs

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]