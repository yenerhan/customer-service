FROM openjdk:11 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package


FROM openjdk:11
WORKDIR customer-service
COPY --from=build target/*.jar customer-service.jar
ENTRYPOINT ["java","-jar","customer-service.jar"]