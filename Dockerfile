FROM openjdk:12-jdk
COPY "./target/client-0.0.1-SNAPSHOT.jar" "client.jar"
ENTRYPOINT ["java","-jar","client.jar"]