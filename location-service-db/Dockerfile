FROM axel9691/karaf-backend

# arguments taken from Maven pom plugin configuration
ARG JAR_FILE
ARG GROUP_ID
ARG ARTIFACT_ID
ARG ARTIFACT_VERSION
ARG SERVICE_JAR
ARG SERVICE_JAR_GROUP_ID
ARG SERVICE_JAR_ARTIFACT_ID
ARG SERVICE_JAR_VERSION

# overwrite configuration inherited from parent image
#COPY etc/* $KARAF_BASE/etc

# Install services in docker-local Maven repository
USER $KARAF_USER
RUN cd ~
COPY target/${JAR_FILE} .
COPY lib/${SERVICE_JAR} .
RUN mvn -q install:install-file -Dfile=${JAR_FILE} -DgroupId=${GROUP_ID} -DartifactId=${ARTIFACT_ID} -Dversion=${ARTIFACT_VERSION} -Dpackaging=jar
RUN mvn -q install:install-file -Dfile=${SERVICE_JAR} -DgroupId=${SERVICE_JAR_GROUP_ID} -DartifactId=${SERVICE_JAR_ARTIFACT_ID} -Dversion=${SERVICE_JAR_VERSION} -Dpackaging=jar

# Start karaf right from start since it's creating instance files ('server mode')
#RUN exec $KARAF_BASE/bin/start 

# Adding the feature that contains the service bundles to the Karaf instance
COPY target/feature/feature.xml ${KARAF_BASE}/deploy
#COPY src/main/feature/feature.xml ${KARAF_BASE}/deploy

EXPOSE 8181

CMD ["/opt/karaf/bin/karaf","run"]
#CMD ["/bin/bash"]