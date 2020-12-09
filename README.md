# Exchange Application

## Requirements
* Java 8 or higher
* MySQL 5.6 or higher

## Run & build

### Docker
To run in docker-compose you need to execute in terminal the next command:
```
$ docker-compose up
``` 

### Maven
To run using Maven you need to follow the next steps:
1. Create database `exchange`

2. Run the follow command in the terminal:
* Windows
```
$ ./mvnw.cmd spring-boot:run
```

* Linux
```
$ ./mvnw spring-boot:run
```