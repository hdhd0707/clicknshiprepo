FROM openjdk:17-oracle

EXPOSE 8765

ADD /target/clicknship-payment-service-0.0.1-SNAPSHOT.jar payment-service.jar

RUN groupadd --system clicknship && useradd --system clicknship -g clicknship
RUN chown -R clicknship /payment-service.jar
RUN chown -R clicknship /var/log

USER clicknship

ENTRYPOINT ["java", "-jar","/payment-service.jar"]