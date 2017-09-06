FROM centos



ENV PAYARA_URL build/payara-micro-4.1.1.164.jar

RUN yum install -y java-1.8.0-openjdk-devel ipa-gothic-fonts

ADD $PAYARA_URL /opt/payaradocker/payara-micro-4.1.1.164.jar
ADD build/libs/payaradocker.war /opt/payaradocker/payaradocker.war

WORKDIR /opt/payaradocker

ENTRYPOINT ["java", "-jar", "payara-micro-4.1.1.164.jar", "--noCluster", "--deploy", "payaradocker.war"]
