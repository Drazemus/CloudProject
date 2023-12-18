FROM tomcat:8.0-alpine

LABEL maintainer=”mloubout@enssat.fr”

ADD /target/todolist-1.0.0-SNAPSHOT.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]