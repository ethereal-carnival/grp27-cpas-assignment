FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
COPY configuration.yml configuration.yml
ENTRYPOINT ["java", "-jar", "application.jar"]