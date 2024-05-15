FROM amazoncorretto:21
WORKDIR /app
COPY . /app
CMD [ "./mvnw", "spring-boot:run" ]