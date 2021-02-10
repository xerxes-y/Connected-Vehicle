FROM openjdk:11
COPY ./code/lemon-backend/target/lemon-0.0.1-SNAPSHOT.jar /usr/src/
WORKDIR /usr/src/
EXPOSE 8080
CMD ["java", "-jar", "lemon-0.0.1-SNAPSHOT.jar"]