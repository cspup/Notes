FROM openjdk:11
MAINTAINER cspup
ADD target/classes/notes.db /home/notes.db
ADD target/notes-0.0.1-SNAPSHOT.jar /home/app.jar
VOLUME /home/file
RUN echo "Asia/Shanghai" > /etc/timezone
EXPOSE  8483
WORKDIR /home
RUN bash -c 'touch /home/app.jar'
ENTRYPOINT ["java", "-jar","/home/app.jar"]