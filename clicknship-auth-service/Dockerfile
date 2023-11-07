FROM openjdk:17-oracle

EXPOSE 8780

ADD /target/clicknship-auth-service-0.0.1-SNAPSHOT.jar auth-service.jar
ADD /target/classes/jwt.jks jwt.jks

RUN groupadd --system clicknship && useradd --system clicknship -g clicknship
RUN chown -R clicknship /auth-service.jar
RUN chown -R clicknship /jwt.jks
RUN chown -R clicknship /var/log

USER clicknship

ENTRYPOINT ["java", "-jar","/auth-service.jar"]