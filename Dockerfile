FROM openjdk:11 
COPY ./target/calculator-1.0-SNAPSHOT.jar ./calculator
WORKDIR /calculator
CMD ["java", "-jar", "calculator-1.0-SNAPSHOT.jar"]