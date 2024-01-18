#Take the base imagse(java, os, maven included)
FROM maven:3.9.6-eclipse-temurin-11-alpine

#Install jq and curl to check status of the selenium hub and nodes are up or not.
RUN apk add jq
RUN  apk add curl

#Copy the Project code
COPY src /home/SeleniumCucumberTestFramework/src

COPY pom.xml  /home/SeleniumCucumberTestFramework/pom.xml

COPY testng.xml  /home/SeleniumCucumberTestFramework/testng.xml

#Copy runner file
COPY runner.sh runner.sh

#To make runner file compatiable with DOS System
RUN dos2unix runner.sh

#Build the Project to download all the required jar's
RUN mvn -f /home/SeleniumCucumberTestFramework/pom.xml clean test -DskipTests=true

#Run the shell script file here
ENTRYPOINT sh runner.sh


