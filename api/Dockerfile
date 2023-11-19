FROM amazoncorretto:17
WORKDIR /usr/local/src
COPY . .
RUN [ "./gradlew", "clean" ]
RUN [ "./gradlew", "build" ]
EXPOSE 8080
CMD [ "java", "-jar", "build/libs/api-1.0.0.jar" ]