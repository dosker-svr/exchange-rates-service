FROM openjdk:11
EXPOSE 8080
RUN mkdir ./exchange-rates
ADD build/libs/exchange-rates-service-0.0.1-SNAPSHOT.jar ./exchange-rates/exchange-rates.jar
ENTRYPOINT ["java", "-jar", "./exchange-rates/exchange-rates.jar"]