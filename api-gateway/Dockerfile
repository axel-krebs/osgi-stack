FROM axel9691/karaf-web
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

# overwrite configuration inherited from parent image
COPY etc/* $KARAF_BASE/etc

# Start karaf right from start since it's creating instance files ('server mode')
RUN exec /opt/karaf/bin/start 

RUN cd ~
COPY target/${JAR_FILE} .
RUN mvn install:install-file -Dfile=${JAR_FILE} -DgroupId=${GROUP_ID} -DartifactId=${ARTIFFACT_ID} -Dversion=${ARTIFACT_VERSION} -Dpackaging=jar

# Actual deployment
COPY target/feature/feature.xml $KARAF_BASE/deploy

EXPOSE 1099 8081 8765 44444

# Run Karaf on container start-up
CMD ["/opt/karaf/bin/karaf", "run"]
