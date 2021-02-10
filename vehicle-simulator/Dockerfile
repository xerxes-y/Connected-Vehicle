FROM registry.kian.digital/openjdk:11-jdk-slim-buster-apm-metric

RUN ln -s /usr/lib/libfontconfig.so.1 /usr/lib/libfontconfig.so && \
    ln -s /lib/libuuid.so.1 /usr/lib/libuuid.so.1 && \
    ln -s /lib/libc.musl-x86_64.so.1 /usr/lib/libc.musl-x86_64.so.1
RUN mkdir /opt/shareclasses

ENV LD_LIBRARY_PATH /usr/lib

VOLUME /tmp
ARG JAR_FILE

ADD ${JAR_FILE} /opt/app/app.jar
EXPOSE 9201
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app/app.jar"]
