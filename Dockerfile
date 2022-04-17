FROM openjdk:11-slim AS BUILD

VOLUME /root/.m2
COPY $PWD "/usr/src/apps"

WORKDIR /usr/src/apps
RUN chmod +x mvnw
RUN --mount=type=cache,target=/root/.m2 ./mvnw clean package

FROM openjdk:11-jre-slim

RUN apt-get update && apt-get install curl -y

COPY --from=BUILD /usr/src/apps/target/*.jar app.jar
ENV profile=${PROFILE}

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=${profile}", "app.jar"]
