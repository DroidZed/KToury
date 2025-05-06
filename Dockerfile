FROM gradle:8.13-alpine AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle clean bootJar --no-daemon

FROM openjdk:21-slim-bookworm

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/ktoury.jar

ENTRYPOINT ["java","-jar","/app/ktoury.jar"]
