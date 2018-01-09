set SERVICE_NAME=kafka-consumer
set SERVICE_VERSION=1.0.1
set GROUP_ID=com.netposa.poseidon
set ARTIFACT_ID=kafka-consumer
if errorlevel 1 (
    echo "can not find MAVEN_HOME, please install mvn first!"
) else (
    mvn install:install-file -Dfile=%SERVICE_NAME%-%SERVICE_VERSION%.jar -DgroupId=%GROUP_ID% -DartifactId=%ARTIFACTED_ID% -Dversion=%SERVICE_VERSION% -Dpackaging=jar
)
pause