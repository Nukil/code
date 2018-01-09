#!/bin/sh
SERVICE_NAME="kafka-consumer"
SERVICE_VERSION="1.0.1"
GROUP_ID="com.netposa.poseidon"
ARTIFACTED_ID="kafka-consumer"
if ${MAVEN_HOME} == "";then
    echo "can not find MAVEN_HOME, please install mvn first!"
else
    echo "mvn install:install-file -Dfile=$SERVICE_NAME-$SERVICE_VERSION.jar -DgroupId=$GROUP_ID -DartifactId=$ARTIFACTED_ID -Dversion=$SERVICE_VERSION -Dpackaging=jar"
    mvn install:install-file -Dfile=$SERVICE_NAME-$SERVICE_VERSION.jar -DgroupId=$GROUP_ID -DartifactId=$ARTIFACTED_ID -Dversion=$SERVICE_VERSION -Dpackaging=jar
fi