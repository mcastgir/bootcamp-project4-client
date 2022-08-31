# Project Client
> Microservice **Client** Bootcamp NTT Data

This project include:
- Spring Boot Webflux
- Spring Boot Data MongoDB Reactive
- Spring Cloud Config
- Spring Cloud Eureka Client
- Spring Cloud Bootstrap
- Spring Boot Actuator
- WebTestClient
- JUnit
- Mockito
- SonarQube
- Lombok
- Github Actions
- Docker

### Docker

1. Create Image Config Server in Docker
```  
docker build -t client .
```

2. Create Container

```
docker run -p 8086:8086 --name client-instance --link config-server-instance:latest -d client:latest
```

### SonarQube

```
mvn clean verify sonar:sonar -Dsonar.projectKey=client -Dsonar.host.url=http://localhost:9093 -Dsonar.login=sqp_9ea85581b15c5653d306819425fe5c72a59734ba
```