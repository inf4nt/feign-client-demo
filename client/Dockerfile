FROM maven:3.9.6 AS build

WORKDIR /project

COPY pom.xml .
RUN mvn verify clean --fail-never

COPY src/ src/
RUN mvn package

FROM openjdk:21

EXPOSE 8080

COPY --from=build /project/target/*.jar application.jar

CMD ["java", "-jar", "application.jar"]