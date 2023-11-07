FROM openjdk:17-oracle

EXPOSE 8770

ADD /target/clicknship-gateway-0.0.1-SNAPSHOT.jar gateway.jar

RUN groupadd --system clicknship && useradd --system clicknship -g clicknship
RUN chown -R clicknship /gateway.jar
RUN chown -R clicknship /var/log

USER clicknship

ENTRYPOINT ["java", "-jar","/gateway.jar"]