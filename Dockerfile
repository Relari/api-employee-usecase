FROM openjdk:11.0-jre-slim
EXPOSE 8080
ARG JAR_FILE=target/demo-api-1.0.0-SNAPSHOT.jar
ADD ${JAR_FILE} demo.jar
ENTRYPOINT ["java","-jar","/demo.jar"]