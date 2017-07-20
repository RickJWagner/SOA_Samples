#!/bin/bash

FSW_HOME=/home/rick/Tools/A/FSW6.0/Install4AMQCase


# PATCH_HOME... location of unzipped BZ-1146192.zip from https://access.redhat.com/jbossnetwork/restricted/softwareDownload.html
PATCH_HOME=/home/rick/Tools/A/FSW6.0/Patches/BZ-1085860

# Are we in the right place?

if [ -e "$FSW_HOME/jboss-eap-6.1/dtgov-sramp-repo-seed-cli-commands.txt" ]
then
  echo "FSW_HOME  : $FSW_HOME set correctly"
else
  echo "FSW_HOME does not look right"
  exit 1
fi


if [ -e "$PATCH_HOME/removed-list-base.txt" ]
then
  echo "PATCH_HOME: $PATCH_HOME set correctly"
else
  echo "PATCH_HOME does not look right"
  exit 1
fi

# check if rtgov is installed
RT_TYPE="none"
shopt -s nullglob
set -- "$FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/overlord-rtgov.war/WEB-INF/lib/activity-server-restc*"
if [ "$#" -gt 0 ]; then
  RT_TYPE="client"
fi

shopt -s nullglob
set -- "$FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/overlord-rtgov.war/WEB-INF/lib/activity-server-rests*"
if [ "$#" -gt 0 ]; then
    RT_TYPE="server"
fi

echo "RT-GOV installation: $RT_TYPE"
echo "-------------------------------------------------"    

echo "Switchyard module before patching: " 
ls -l $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/common/main/

echo "Removing files from removed-list-base.txt"
# removed-list-base.txt


		  rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/base/org/jboss/as/ejb3/
		  rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/base/org/jboss/as/web/main/


echo "Removing files from removed-list-dtgov"
# removed-list-dtgov


		rm -rf $FSW_HOME/jboss-eap-6.1/dtgov-data/pom.xml
		rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/dtgov-ui.war/WEB-INF/classes/classlist.mf
		rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/dtgov-ui.war/WEB-INF/lib/commons-fileupload-1.2.2.jar
		rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/dtgov-ui.war/WEB-INF/lib/s-ramp-common-0.3.1.Final-redhat-7.jar
		rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/dtgov-ui.war/app/
		rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/dtgov.war/WEB-INF/classes/org/overlord/dtgov/taskapi/TaskApi.class
		rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/dtgov.war/WEB-INF/classes/org/overlord/sramp/governance/services/DeploymentResource$1.class
		rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/dtgov.war/WEB-INF/classes/org/overlord/sramp/governance/services/DeploymentResource.class
		rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/dtgov.war/WEB-INF/lib/s-ramp-common-0.3.1.Final-redhat-7.jar
		rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/dtgov.war/WEB-INF/lib/s-ramp-wagon-0.3.1.Final-redhat-7.jar
		rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/dtgov.war/WEB-INF/lib/xstream-1.4.3.jar
		rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/dtgov/dtgov-demos-project/pom.xml
		rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/dtgov/dtgov-demos-project/project-requirements/pom.xml
		rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/dtgov/dtgov-demos-project/project-service-api/pom.xml
		rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/dtgov/dtgov-demos-project/project-service-impl/pom.xml
		rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/dtgov/dtgov-demos-switchyard/pom.xml
		rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/dtgov/pom.xml

if [ $RT_TYPE = "client" ]
then
   echo "Removing files from removed-list-rtgov-client"
   # removed-list-rtgov-client
    rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/mvel/mvel2/main/module.xml
    rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/mvel/mvel2/main/mvel2-2.1.7.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/overlord/commons/overlord-commons-auth/main/module.xml
    rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/overlord/commons/overlord-commons-auth/main/overlord-commons-auth-1.1.0-redhat-7.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/overlord/rtgov/main/acs-epn-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/overlord/rtgov/main/active-collection-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/overlord/rtgov/main/activity-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/overlord/rtgov/main/analytics-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/overlord/rtgov/main/ep-core-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/overlord/rtgov/main/ep-drools-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/overlord/rtgov/main/ep-mvel-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/overlord/rtgov/main/epn-core-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/overlord/rtgov/main/module.xml
    rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/overlord/rtgov/main/rtgov-common-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/WEB-INF/jboss-web.xml
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/WEB-INF/picketlink.xml
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/WEB-INF/web.xml
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/hosted/index.jsp
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/index.jsp
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/login-error.html
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/login.html
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/resources/idp-responsive.css
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/resources/idp.css
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/resources/images/login-background-phone.jpg
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/resources/images/login-background-phone_rh.jpg
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/resources/images/login-background.jpg
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/resources/images/login-background_rh.jpg
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/resources/images/login-screen-logo_rh.png
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/resources/images/logo-type_rh.png
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war/resources/jquery-1.9.1/jquery.min.js
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-commons-idp.war.dodeploy
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/overlord-rtgov.war/WEB-INF/beans.xml
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/overlord-rtgov.war/WEB-INF/lib/active-collection-jee-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/overlord-rtgov.war/WEB-INF/lib/activity-client-jee-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/overlord-rtgov.war/WEB-INF/lib/activity-server-restc-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/overlord-rtgov.war/WEB-INF/lib/collector-activity-server-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/overlord-rtgov.war/WEB-INF/lib/commons-codec-1.4-redhat-2.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/overlord-rtgov.war/WEB-INF/lib/overlord-commons-config-1.1.0-redhat-7.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/overlord-rtgov.war/WEB-INF/lib/rtgov-client-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/overlord-rtgov.war/WEB-INF/lib/rtgov-infinispan-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/overlord-rtgov.war/WEB-INF/lib/rtgov-jbossas-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/overlord-rtgov.war/WEB-INF/lib/rtgov-switchyard-1.0.1.Final-redhat-4.jar
    rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/overlord-rtgov.war.dodeploy
fi

if [ $RT_TYPE = "server" ]
then

   echo "Removing files from removed-list-rtgov-server"
   # removed-list-rtgov-server
	rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/gadget-web.war/WEB-INF/lib/commons-fileupload-1.2.2.jar
	rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/overlord-rtgov/gadget-web.war/WEB-INF/lib/xstream-1.4.3.jar
	rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/rtgov/activityclient/pom.xml
	rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/rtgov/ordermgmt/app/pom.xml
	rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/rtgov/ordermgmt/ip/pom.xml
	rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/rtgov/ordermgmt/pom.xml
	rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/rtgov/policy/async/pom.xml
	rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/rtgov/policy/pom.xml
	rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/rtgov/policy/sync/pom.xml
	rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/rtgov/pom.xml
	rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/rtgov/sla/epn/pom.xml
	rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/rtgov/sla/monitor/pom.xml
	rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/rtgov/sla/pom.xml
	rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/rtgov/sla/report/pom.xml
fi

echo "Removing files from removed-list-sramp"
# removed-list-sramp

rm -rf $FSW_HOME/jboss-eap-6.1/bin/s-ramp-shell-*.jar
rm -rf $FSW_HOME/jboss-eap-6.1/bin/s-ramp.bat
rm -rf $FSW_HOME/jboss-eap-6.1/bin/s-ramp.sh
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-archive-package/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-archive-package/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-archive-package/src/main/java/org/overlord/sramp/demos/archivepkg/ArchivePackageDemo.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-archive-package/src/main/resources/org/overlord/sramp/demos/archivepkg/wss-wssecurity-secext-1.0.xsd
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-archive-package/src/main/resources/org/overlord/sramp/demos/archivepkg/wss-wssecurity-utility-1.0.xsd
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-archive-package/src/main/resources/org/overlord/sramp/demos/archivepkg/wstx-wsba-1.1-schema-200701.xsd
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-archive-package/src/main/resources/org/overlord/sramp/demos/archivepkg/wstx-wsba-1.1-wsdl-200702.wsdl
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-classifications/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-classifications/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-classifications/src/main/java/org/overlord/sramp/demos/classifications/ClassificationDemo.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-classifications/src/main/resources/org/overlord/sramp/demos/classifications/classifications-demo-doc-1.txt
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-classifications/src/main/resources/org/overlord/sramp/demos/classifications/classifications-demo-doc-2.txt
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-classifications/src/main/resources/org/overlord/sramp/demos/classifications/regions.owl.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-custom-deriver/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-custom-deriver/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-custom-deriver/src/main/java/org/overlord/sramp/demos/deriver/CustomDeriverDemo.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-custom-deriver/src/main/java/org/overlord/sramp/demos/deriver/WebXmlArtifactCollection.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-custom-deriver/src/main/java/org/overlord/sramp/demos/deriver/WebXmlDeriver.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-custom-deriver/src/main/java/org/overlord/sramp/demos/deriver/WebXmlDeriverProvider.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-custom-deriver/src/main/resources/org/overlord/sramp/demos/deriver/web.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-derived-artifacts/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-derived-artifacts/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-derived-artifacts/src/main/java/org/overlord/sramp/demos/derived/DerivedArtifactsDemo.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-derived-artifacts/src/main/resources/org/overlord/sramp/demos/derived/sample.wsdl
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-mvn-integration/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-mvn-integration/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-mvn-integration/s-ramp-demos-mvn-integration-app/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-mvn-integration/s-ramp-demos-mvn-integration-app/src/main/java/org/overlord/sramp/demos/mvnintegration/app/SrampMavenIntegrationDemo.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-mvn-integration/s-ramp-demos-mvn-integration-app/src/test/java/org/overlord/sramp/demos/mvnintegration/app/SrampMavenIntegrationDemoTest.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-mvn-integration/s-ramp-demos-mvn-integration-artifacts/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-mvn-integration/s-ramp-demos-mvn-integration-artifacts/src/main/resources/schemas/address.xsd
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-mvn-integration/s-ramp-demos-mvn-integration-artifacts/src/main/resources/schemas/person.xsd
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-mvn-integration/s-ramp-demos-mvn-integration-artifacts/src/test/java/org/overlord/sramp/demos/mvnintegration/PersonTypeTest.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-ontologies/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-ontologies/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-ontologies/src/main/java/org/overlord/sramp/demos/ontologies/OntologyDemo.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-ontologies/src/main/resources/org/overlord/sramp/demos/ontologies/sample-ontology-1.owl.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-ontologies/src/main/resources/org/overlord/sramp/demos/ontologies/sample-ontology-2.owl.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-properties/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-properties/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-properties/src/main/java/org/overlord/sramp/demos/properties/PropertyDemo.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-properties/src/main/resources/org/overlord/sramp/demos/properties/property-demo-doc-1.txt
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-properties/src/main/resources/org/overlord/sramp/demos/properties/property-demo-doc-2.txt
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-query/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-query/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-query/src/main/java/org/overlord/sramp/demos/query/QueryDemo.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-query/src/main/resources/org/overlord/sramp/demos/query/archive-package.sramp
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-relationships/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-relationships/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-relationships/src/main/java/org/overlord/sramp/demos/relationships/RelationshipDemo.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-relationships/src/main/resources/org/overlord/sramp/demos/relationships/relationship-demo-doc-1.txt
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-relationships/src/main/resources/org/overlord/sramp/demos/relationships/relationship-demo-doc-2.txt
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-relationships/src/main/resources/org/overlord/sramp/demos/relationships/relationship-demo-doc-3.txt
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-shell-command/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-shell-command/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-shell-command/src/main/java/org/overlord/sramp/demos/shell/commands/JvmCommandProvider.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-shell-command/src/main/java/org/overlord/sramp/demos/shell/commands/JvmStatusCommand.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-simple-client/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-simple-client/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-simple-client/src/main/java/org/overlord/sramp/demos/simpleclient/SimpleClientDemo.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-simple-client/src/main/resources/org/overlord/sramp/demos/simpleclient/ws-humantask-context.xsd
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-simple-client/src/main/resources/org/overlord/sramp/demos/simpleclient/ws-humantask-leantask-api.wsdl
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-simple-client/src/main/resources/org/overlord/sramp/demos/simpleclient/ws-humantask-policy.xsd
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-simple-client/src/main/resources/org/overlord/sramp/demos/simpleclient/ws-humantask-protocol.wsdl
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-simple-client/src/main/resources/org/overlord/sramp/demos/simpleclient/ws-humantask-types.xsd
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-simple-client/src/main/resources/org/overlord/sramp/demos/simpleclient/ws-humantask.xsd
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard/src/main/java/org/overlord/sramp/demos/switchyard/service/InventoryService.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard/src/main/java/org/overlord/sramp/demos/switchyard/service/InventoryServiceBean.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard/src/main/java/org/overlord/sramp/demos/switchyard/service/Item.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard/src/main/java/org/overlord/sramp/demos/switchyard/service/ItemNotFoundException.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard/src/main/java/org/overlord/sramp/demos/switchyard/service/Order.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard/src/main/java/org/overlord/sramp/demos/switchyard/service/OrderAck.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard/src/main/java/org/overlord/sramp/demos/switchyard/service/OrderService.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard/src/main/java/org/overlord/sramp/demos/switchyard/service/OrderServiceBean.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard/src/main/java/org/overlord/sramp/demos/switchyard/service/Transformers.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard/src/main/resources/wsdl/OrderService.wsdl
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/artifacts/Readme.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/artifacts/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/artifacts/src/main/java/org/switchyard/quickstarts/demo/multiapp/InventoryService.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/artifacts/src/main/java/org/switchyard/quickstarts/demo/multiapp/Item.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/artifacts/src/main/java/org/switchyard/quickstarts/demo/multiapp/ItemNotFoundException.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/artifacts/src/main/java/org/switchyard/quickstarts/demo/multiapp/Order.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/artifacts/src/main/java/org/switchyard/quickstarts/demo/multiapp/OrderAck.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/artifacts/src/main/java/org/switchyard/quickstarts/demo/multiapp/OrderService.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/artifacts/src/main/resources/OrderService.wsdl
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/artifacts/src/main/resources/orderTypes.xsd
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/order-consumer/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/order-consumer/order-consumer.jpg
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/order-consumer/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/order-service/Readme.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/order-service/order-service.jpg
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/order-service/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/order-service/src/main/java/org/switchyard/quickstarts/demo/multiapp/service/InventoryServiceBean.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/order-service/src/main/java/org/switchyard/quickstarts/demo/multiapp/service/OrderServiceBean.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/order-service/src/main/java/org/switchyard/quickstarts/demo/multiapp/service/Transformers.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/web/README.md
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/web/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/web/src/main/java/org/switchyard/quickstarts/demo/multiapp/web/ItemEntry.java
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/web/src/main/webapp/WEB-INF/beans.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/web/src/main/webapp/WEB-INF/faces-config.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/web/src/main/webapp/home.xhtml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/overlord/sramp/s-ramp-demos-switchyard-multiapp/web/src/main/webapp/index.html
rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/s-ramp-server.war/WEB-INF/lib/s-ramp-common-*.jar
rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/s-ramp-ui.war/WEB-INF/classes/classlist.mf
rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/s-ramp-ui.war/WEB-INF/lib/commons-fileupload-1.2.2.jar
rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/s-ramp-ui.war/WEB-INF/lib/s-ramp-common-*.jar
rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/s-ramp-ui.war/app/

echo "Removing files from removed-list-switchyard.txt"
# removed-list-switchyard.txt

rm -rf $FSW_HOME/jboss-eap-6.1/docs/schema/soa/org/apache/camel/schema/spring/camel-spring.xsd
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/com/thoughtworks/xstream/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/apache/camel/core/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/apache/camel/cxf/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/apache/camel/ftp/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/apache/camel/jms/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/apache/camel/jpa/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/apache/camel/mail/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/apache/camel/netty/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/apache/camel/quartz/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/apache/camel/soap/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/apache/camel/spring/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/apache/camel/sql/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/api/extensions/wsdl/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/api/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/bus/camel/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/common/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/component/bean/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/component/bpel/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/component/bpm/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/component/camel/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/component/camel/switchyard/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/component/common/camel/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/component/common/knowledge/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/component/common/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/component/http/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/component/jca/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/component/resteasy/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/component/rules/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/component/sca/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/component/soap/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/config/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/deploy/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/remote/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/runtime/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/security/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/transform/main/
rm -rf $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/validate/main/
rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/switchyard-bpel-console-server.war/WEB-INF/lib/commons-fileupload-1.2.1.jar
rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/switchyard-bpel-console-server.war/WEB-INF/lib/riftsaw-console-integration-*.jar
rm -rf $FSW_HOME/jboss-eap-6.1/standalone/deployments/switchyard-bpel-console-server.war/WEB-INF/lib/riftsaw-console-integration-*.jar
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/bean-service/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/bpel-service/jms_binding/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/bpel-service/loan_approval/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/bpel-service/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/bpel-service/say_hello/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/bpel-service/simple_correlation/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/bpm-service/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/camel-binding/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/camel-ftp-binding/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/camel-jaxb/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/camel-jms-binding/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/camel-jpa-binding/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/camel-mail-binding/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/camel-netty-binding/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/camel-quartz-binding/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/camel-service/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/camel-soap-proxy/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/camel-sql-binding/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/cluster/client/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/cluster/credit/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/cluster/dealer/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/cluster/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/multiApp/artifacts/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/multiApp/order-consumer/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/multiApp/order-service/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/multiApp/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/multiApp/web/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/orders/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/policy-security-basic/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/policy-security-basic-propagate/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/policy-security-cert/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/policy-security-saml/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/policy-security-wss-signencrypt/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/policy-security-wss-username/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/policy-transaction/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/transaction-propagation/client/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/transaction-propagation/credit/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/transaction-propagation/dealer/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/demos/transaction-propagation/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/ear-deployment/artifacts/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/ear-deployment/ear-assembly/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/ear-deployment/order-consumer/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/ear-deployment/order-service/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/ear-deployment/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/http-binding/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/jca-inflow-hornetq/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/jca-outbound-hornetq/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/remote-invoker/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/rest-binding/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/rules-camel-cbr/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/rules-interview/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/rules-interview-container/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/rules-interview-dtable/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/soap-addressing/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/soap-attachment/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/soap-binding-rpc/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/soap-mtom/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/transform-jaxb/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/transform-json/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/transform-smooks/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/qui-ckstarts/switchyard/transform-xslt/pom.xml
rm -rf $FSW_HOME/jboss-eap-6.1/quickstarts/switchyard/validate-xml/pom.xml

echo "Unzipping patch files to $FSW_HOME now"
unzip -oq $PATCH_HOME/fsw-6.0_2_2014-base.zip -d $FSW_HOME
unzip -oq $PATCH_HOME/fsw-6.0_2_2014-dtgov.zip -d $FSW_HOME
if [ $RT_TYPE = "server" ]
then
   unzip -oq $PATCH_HOME/fsw-6.0_2_2014-rtgov-server.zip -d $FSW_HOME
fi
if [ $RT_TYPE = "client" ]
then
   unzip -oq $PATCH_HOME/fsw-6.0_2_2014-rtgov-client.zip -d $FSW_HOME
fi   
unzip -oq $PATCH_HOME/fsw-6.0_2_2014-s-ramp.zip -d $FSW_HOME
unzip -oq $PATCH_HOME/fsw-6.0_2_2014-switchyard.zip -d $FSW_HOME


echo "Switchyard module after patching: " 
ls -l $FSW_HOME/jboss-eap-6.1/modules/system/layers/soa/org/switchyard/common/main/









