FROM tomcat
COPY yaso-webapp/target/yaso-webapp.war /usr/local/tomcat/webapps/
EXPOSE 8081
CMD ["catalina.sh", "run"]