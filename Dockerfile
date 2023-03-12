FROM openjdk:11 
RUN mkdir -p /app
COPY ./target/calculator-1.0-SNAPSHOT.jar /app
WORKDIR /app
CMD ["java", "-jar", "calculator-1.0-SNAPSHOT.jar"]