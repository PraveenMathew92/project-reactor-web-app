# Web based Reactive Stack


## Technolgies

### Database: 
* MonogoDB

### Backend:
* Java 11
* Spring Boot 2

### FrontEnd
* HTML, CSS, Javascript

### Infrastructure
* docker

## Starting App

On a machine having java 11 installed and running a dokcer deamon run the following
```
➜ docker run --name mongo-container -p 27017:27017 -d mongo # run monogo db using docker
➜ ./gradlew clean build bootrun # start the springboot app
```

