FROM java:8

LABEL author="XX <xieyaqi11@gmail.com>"

EXPOSE 8761

VOLUME /tmp
COPY target/eureka-server.jar /usr/local/eureka-server.jar
WORKDIR /usr/local
ENTRYPOINT ["java", "jar", "/usr/local/eureka-server.jar"]