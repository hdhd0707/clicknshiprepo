FROM openjdk:17-oracle

EXPOSE 8761

ADD /target/clicknship-registry-0.0.1-SNAPSHOT.jar eureka.jar

RUN groupadd --system clicknship && useradd --system clicknship -g clicknship
RUN chown -R clicknship /eureka.jar
RUN chown -R clicknship /var/log

USER clicknship

ENTRYPOINT ["java", "-jar","/eureka.jar"]

