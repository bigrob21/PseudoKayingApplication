#FROM maven:3.5.4-jdk-8-alpine as build-0
FROM maven:3.5-jdk-8-alpine as build-0
RUN mkdir -p /buildir
WORKDIR /buildir
COPY src/ src/
COPY pom.xml ./
#RUN mvn install
RUN mvn clean install

FROM openjdk:8u171-jdk-alpine3.8
LABEL vendor="By Some Random Developers" \
      version="0.1"
RUN mkdir -p /app
WORKDIR /app
COPY --from=build-0 /buildir/target/*.jar app.jar
EXPOSE 2000
ENTRYPOINT ["java", "-jar", "app.jar"]
