FROM openjdk:8-jre-slim
RUN mkdir /app
COPY config.yaml /app/config.yaml
COPY build/libs/raja-1.0-SNAPSHOT-all.jar /app/raja-1.0-SNAPSHOT-all.jar

EXPOSE 8833
EXPOSE 5005
WORKDIR /app/

CMD ["java", "-jar" , "raja-1.0-SNAPSHOT-all.jar", "server" ,"config.yaml"]