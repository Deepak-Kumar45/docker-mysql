FROM openjdk
WORKDIR /app
COPY ./target/docker-mysql-0.0.1-SNAPSHOT.jar /app
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-mysql-0.0.1-SNAPSHOT.jar"]
# Command to run this project in docker CLI
# docker build -t docker-mysql .
# docker run -p 8080{Host Port}:8085{Container port} -d docker-mysql