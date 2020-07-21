FROM axel9691/karaf
LABEL MAINTAINER Axel Krebs <axel.krebs@online.de>

# Start karaf right away 
RUN exec /opt/karaf/bin/karaf

ARG JAR_FILE
ARG GROUP_ID
ARG ARTIFFACT_ID
ARG ARTIFACT_VERSION
ARG UTIL_JAR
ARG UTIL_VERSION
USER $KARAF_USER
RUN cd ~
COPY install.xml . 
COPY target/${JAR_FILE} .
COPY target/${UTIL_JAR} .
RUN mvn install:install-file -Dfile=${JAR_FILE} -DgroupId=${GROUP_ID} -DartifactId=${ARTIFFACT_ID} -Dversion=${ARTIFACT_VERSION} -Dpackaging=jar
RUN mvn install:install-file -Dfile=${UTIL_JAR} -DgroupId=de.akrebs.stackio -DartifactId=stack-util-sun-misc -Dversion=${UTIL_VERSION} -Dpackaging=jar


# install dependencies; optionally copy user settings.xml to .m2 directory
RUN mvn -f install.xml verify

COPY target/feature/feature.xml /opt/karaf/deploy

# install application
#COPY target/api-gateway.kar /opt/karaf/deploy

EXPOSE 1099 8081 8181 44444

USER root

#CMD ["/bin/bash"]
CMD ["/opt/karaf/bin/karaf", "run"]
