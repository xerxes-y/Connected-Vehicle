FROM openjdk:11
COPY ./target/vehicle-connector-1.0-SNAPSHOT.jar /usr/src/
WORKDIR /usr/src/
EXPOSE 9202
CMD ["java", "-jar", "vehicle-connector-1.0-SNAPSHOT.jar"]