FROM gradle:jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test --no-daemon

FROM openjdk:17-alpine
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/*.jar for-developers.jar
ENTRYPOINT ["java", "-jar", "for-developers.jar"]