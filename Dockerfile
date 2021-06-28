FROM tomcat
COPY yaso-webapp/target/yaso-webapp.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]