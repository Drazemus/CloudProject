FROM tomcat:9.0-jdk15-openjdk-slim

RUN rm -rf /usr/local/tomcat/webapps/ROOT

COPY target/todolist-1.0.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]