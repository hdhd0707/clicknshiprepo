FROM openjdk:17-oracle

EXPOSE 8764

ADD /target/clicknship-order-service-0.0.1-SNAPSHOT.jar order-service.jar

RUN groupadd --system clicknship && useradd --system clicknship -g clicknship
RUN chown -R clicknship /order-service.jar
RUN chown -R clicknship /var/log

USER clicknship

ENTRYPOINT ["java", "-jar","/order-service.jar"]