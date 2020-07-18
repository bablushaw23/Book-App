FROM tomcat:latest
RUN rm -rf /usr/local/tomcat/webapps/*
COPY warfile.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh","run"]
EXPOSE 8080