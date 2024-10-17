
FROM openjdk:22.0.2-jdk-slim

# Descargamos Tomcat
ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH
RUN apt-get update && apt-get install -y wget \
    && wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.71/bin/apache-tomcat-9.0.71.tar.gz \
    && tar xvf apache-tomcat-9.0.71.tar.gz \
    && mv apache-tomcat-9.0.71 $CATALINA_HOME \
    && rm apache-tomcat-9.0.71.tar.gz \
    && apt-get remove -y wget \
    && apt-get clean

# Limpia la carpeta de aplicaciones 
RUN rm -rf ${CATALINA_HOME}/webapps/*

RUN ./gradlew clean build

# Copia el archivo WAR generado al directorio webapps de Tomcat
COPY build/libs/back-end-spring-rest-0.0.1-SNAPSHOT.war ${CATALINA_HOME}/webapps/app.war


EXPOSE 8080


CMD ["catalina.sh", "run"]

