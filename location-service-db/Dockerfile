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

# Install bundles and features in docker-local Maven repository
USER $KARAF_USER

RUN cd ~
COPY target/${JAR_FILE} .
COPY lib/${SERVICE_JAR} .
RUN mvn -q install:install-file -Dfile=${JAR_FILE} -DgroupId=${GROUP_ID} -DartifactId=${ARTIFACT_ID} -Dversion=${ARTIFACT_VERSION} -Dpackaging=jar
RUN mvn -q install:install-file -Dfile=${SERVICE_JAR} -DgroupId=${SERVICE_JAR_GROUP_ID} -DartifactId=${SERVICE_JAR_ARTIFACT_ID} -Dversion=${SERVICE_JAR_VERSION} -Dpackaging=jar
COPY target/feature/feature.xml .
COPY feature-repo.xml .
RUN mvn -f feature-repo.xml package install

#RUN echo "location-service-db=mvn:de.akrebs.stackio/location-service-feature/${ARTIFACT_VERSION}/xml/features" >> $KARAF_BASE/etc/org.apache.karaf.features.repos.cfg
#RUN echo "repository.mvn\\:de.akrebs.stackio/location-service-feature/${ARTIFACT_VERSION}/xml/features = mvn:de.akrebs.stackio/location-service-feature/${ARTIFACT_VERSION}/xml/features" >> $KARAF_BASE/etc/profile.cfg
#RUN echo "feature.location-service-db = location-service-db" >> $KARAF_BASE/etc/profile.cfg
RUN echo "default.feature.whitelist.outbound=location-service,location-service-db\ndefault.feature.whitelist.inbound=location-service,location-service-db" >> $KARAF_BASE/etc/org.apache.karaf.cellar.groups.cfg

# Adding the feature that contains the service bundles to the Karaf instance
RUN cp feature.xml ${KARAF_BASE}/deploy

# Start karaf right from start since it's creating instance files ('server mode')
RUN exec $KARAF_BASE/bin/start 
#RUN exec $KARAF_BASE/bin/client feature:repo-add mvn:de.akrebs.stackio/location-service-feature/${ARTIFACT_VERSION}/xml/features
#RUN exec $KARAF_BASE/bin/client feature:install location-service-db

EXPOSE 8181

CMD ["/opt/karaf/bin/karaf","run"]
#CMD ["/bin/bash"]