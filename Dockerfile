FROM openjdk:17.0-slim
EXPOSE 8099
ARG JAR_FILE=target/demo-api-1.0.0-SNAPSHOT.jar
ADD ${JAR_FILE} demo-api.jar
ENTRYPOINT ["java","-jar","/demo-api.jar"]