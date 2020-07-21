FROM axel9691/karaf
LABEL MAINTAINER Axel Krebs <axel.krebs@online.de>

# arguments taken from Maven pom plugin configuration
ARG JAR_FILE
ARG GROUP_ID
ARG ARTIFFACT_ID
ARG ARTIFACT_VERSION
ARG UTIL_JAR
ARG UTIL_VERSION

#ENV values  taken from karaf docker image, see FROM
USER $KARAF_USER

#ENV KARAF_OPTS -Dxyz

# Start karaf right from start since it's creating instance files ('server mode')
RUN exec /opt/karaf/bin/start 

RUN cd ~
COPY target/${JAR_FILE} .
COPY target/${UTIL_JAR} .
RUN mvn install:install-file -Dfile=${JAR_FILE} -DgroupId=${GROUP_ID} -DartifactId=${ARTIFFACT_ID} -Dversion=${ARTIFACT_VERSION} -Dpackaging=jar
RUN mvn install:install-file -Dfile=${UTIL_JAR} -DgroupId=de.akrebs.stackio -DartifactId=stack-util-sun-misc -Dversion=${UTIL_VERSION} -Dpackaging=jar


# install dependencies; optionally copy user settings.xml to .m2 directory
#COPY install.xml . 
#RUN mvn -f install.xml verify

COPY target/feature/feature.xml $KARAF_BASE/deploy

EXPOSE 1099 8081 8888 44444

CMD ["/bin/bash"]
#CMD ["/opt/karaf/bin/karaf", "run"]
