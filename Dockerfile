FROM openjdk:17.0-slim
EXPOSE 8099
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} api-employee-usecase.jar
ENTRYPOINT ["java","-jar","/api-employee-usecase.jar"]