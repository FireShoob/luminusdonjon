FROM openjdk:8-alpine

COPY target/uberjar/luminusdonjon.jar /luminusdonjon/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/luminusdonjon/app.jar"]
