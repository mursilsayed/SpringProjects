# VERSION 1.0
# AUTHOR:         Mursil Sayed 
# DESCRIPTION:    Docker image containing the application 
# TO_BUILD:       docker build -t springsession .
# TO_RUN:         docker run -it --rm -p 8888:8080 springsession



# Latest Tomcat base image for Tomcat8.0 with jre8
FROM mursilsayed/tomcat8

#Removing the Default  applications from Tomcat
RUN rm -f -R /usr/local/tomcat/webapps/ \
    && mkdir /usr/local/tomcat/webapps

#Adding all the dependencies of the application in the tomcat lib directory as a seperate later so that the war file becomes thin
COPY files/project-output-files/libs/*.jar /usr/local/tomcat/lib/

#Adding the setenv files to configure JMX for monitoring the application 
COPY files/jmx-config /usr/local/tomcat/bin/

#Adding SSL certificates and needed configuration files
COPY files/server-config /usr/local/tomcat/conf/


COPY files/project-output-files/springsession.war /usr/local/tomcat/webapps/

