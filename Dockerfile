FROM openjdk:8-jdk-alpine

LABEL Author="Ciornii Alexandr"
LABEL E-mail="alex.ciornii@gamil.com"
LABEL version="0.1"

WORKDIR /app
ADD . /app
RUN cd /app
RUN chmod +x /app/mvnw

EXPOSE 9999

CMD ./mvnw spring-boot:run
