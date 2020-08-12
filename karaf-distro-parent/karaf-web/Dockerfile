FROM openjdk:9
LABEL MAINTAINER Axel Krebs <axel.krebs@online.de>

ENV KARAF_USER karaf
ENV KARAF_UID 8181
ENV KARAF_VERSION 4.2.9
ENV KARAF_BASE "/opt/karaf"
ENV KARAF_LOG "/var/log/karaf"
ENV KARAF_DATA "/tmp"
ENV JAVA_MIN_MEM=256M
ENV JAVA_MAX_MEM=8192M
ENV JAVA_PERM_MEM=256M 
ENV JAVA_MAX_PERM_MEM=518M 
ENV MAVEN_HOME /opt/maven

# Tune Hazelcast for Java 9
ENV KARAF_OPTS --add-modules java.se --add-exports java.base/jdk.internal.ref=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/sun.nio.ch=ALL-UNNAMED --add-opens java.management/sun.management=ALL-UNNAMED --add-opens jdk.management/com.sun.management.internal=ALL-UNNAMED

# Install latest JDK 
RUN apt update && apt-get -y install wget procps file apt-transport-https

RUN addgroup --gid $KARAF_UID $KARAF_USER
RUN	adduser --gid $KARAF_UID --shell /bin/bash --home /home/karaf $KARAF_USER

RUN mkdir -p $KARAF_BASE
RUN mkdir $KARAF_LOG -m 1777 && chown $KARAF_USER: $KARAF_LOG
RUN mkdir /tmp/tmp && chown $KARAF_USER: /tmp/tmp

# Simply copy the assembled Karaf distro into the container
COPY target/assembly $KARAF_BASE

RUN chown $KARAF_USER: $KARAF_BASE -R && chmod 775 $KARAF_BASE -R

# Install Maven, used by Karaf as a local repository through OPS4J PAX Maven connector
RUN wget https://www-us.apache.org/dist/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz -P /tmp
RUN tar xf /tmp/apache-maven-*.tar.gz -C /opt
RUN ln -s /opt/apache-maven-3.6.3 /opt/maven
ENV PATH="$MAVEN_HOME/bin:${PATH}"

# preparing repository access for user KARAF
COPY settings.xml /opt/maven/conf/

USER ${KARAF_USER}
#RUN exec ${KARAF_BASE}/bin/start 

RUN cd ~
COPY install.xml .
RUN mvn -f install.xml -PlocalOutputDir verify

EXPOSE 1099 5701 8081 8181 44444

CMD ["/opt/karaf/bin/karaf","run"]
#CMD ["/bin/bash"]