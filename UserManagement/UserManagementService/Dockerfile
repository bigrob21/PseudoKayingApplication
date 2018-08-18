FROM maven:3.5.4-jdk-8-alpine as build-0
#ARG EXT_M3_HOME=$M3_REPO_HOME
RUN mkdir -p /buildir
WORKDIR /buildir
##VOLUME [ ${EXT_M3_HOME}, "/root/.m2" ]
COPY src/ src/
COPY pom.xml ./
RUN mvn install

FROM openjdk:8u171-jdk-alpine3.8
LABEL vendor="By Some Random Developers" \
      version="0.1"
RUN mkdir -p /app
WORKDIR /app
COPY --from=build-0 /buildir/target/*.jar app.jar
EXPOSE 2000
ENTRYPOINT ["java", "-jar", "app.jar"]