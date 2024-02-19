FROM openjdk:17-alpine
WORKDIR /app
COPY build/libs/for-developers-0.0.1-SNAPSHOT.jar for-developers.jar
ENTRYPOINT ["java", "-jar", "for-developers.jar"]