FROM debian:10
LABEL MAINTAINER Axel Krebs <axel.krebs@online.de>

ENV JAVA_HOME=/usr/lib/jvm/adoptopenjdk-8-hotspot-amd64/

RUN apt-get update && apt-get install -y apt-utils apt-transport-https ca-certificates gnupg wget software-properties-common
RUN wget -qO - https://adoptopenjdk.jfrog.io/adoptopenjdk/api/gpg/key/public | apt-key add -
RUN add-apt-repository --yes https://adoptopenjdk.jfrog.io/adoptopenjdk/deb/
RUN apt-get update && apt-get -y install adoptopenjdk-8-hotspot

#TODO Change root password
#RUN echo 'Setting new root password.' | passwd -q --stdin root

CMD ["/bin/bash"]