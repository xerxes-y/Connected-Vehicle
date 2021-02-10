FROM openjdk:11
COPY ./target/vehicle-simulator-0.0.1-SNAPSHOT.jar /usr/src/
COPY environmet.env environmet.env
RUN chmod +x entrypoint.sh
WORKDIR /usr/src/
EXPOSE 9201

CMD ["java", "-jar", "vehicle-simulator-0.0.1-SNAPSHOT.jar"]