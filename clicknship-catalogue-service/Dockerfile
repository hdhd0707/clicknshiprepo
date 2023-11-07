FROM openjdk:17-oracle
EXPOSE 8763
ADD /target/clicknship-catalogue-service-0.0.1-SNAPSHOT.jar catalogue-service.jar
ENTRYPOINT ["java", "-jar","/catalogue-service.jar"]