FROM java:8

LABEL author="XX <xieyaqi11@gmail.com>"

EXPOSE 8888

VOLUME /tmp
COPY target/config.jar /usr/local/config.jar
WORKDIR /usr/local
ENTRYPOINT ["java", "jar", "/usr/local/config.jar"]