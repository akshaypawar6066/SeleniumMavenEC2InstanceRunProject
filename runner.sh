echo "-----------------------------------------------------"
echo "Starting intialization"
echo "-----------------------------------------------------"
#Do not start the tests imediately. Hub has to be ready with browser nodes.
echo "Checking is hub is ready...!!!"
count=0
while [ "$( curl -s http://172.26.48.1:4444/status | jq -r .value.ready )" !="true" ]
do
  count=$((count+1))
  echo "Attempt: ${count}"
  if [ "$count" -ge 30]
  then
      echo "****** HUB IS NOT READY WITHIN 30 SECONDS *****"
      exit 1
  fi
  sleep 1
done

#At this point, selenium gris should be up!
echo "Selenium Grid is up and running. Running the test..."

mvn -f /home/SeleniumCucumberTestFramework/pom.xml  test -DcliBrowser=${browser}