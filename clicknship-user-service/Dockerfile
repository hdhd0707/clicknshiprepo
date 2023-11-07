FROM openjdk:17-oracle

EXPOSE 8766

ADD /target/clicknship-user-service-0.0.1-SNAPSHOT.jar user-service.jar

RUN groupadd --system clicknship && useradd --system clicknship -g clicknship
RUN chown -R clicknship /user-service.jar
RUN chown -R clicknship /var/log

USER clicknship

ENTRYPOINT ["java", "-jar","/user-service.jar"]