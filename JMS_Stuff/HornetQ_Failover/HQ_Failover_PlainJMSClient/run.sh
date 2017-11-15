#!/usr/bin/env bash

REMOTE_NAMING=/home/rick/.m2/repository/org/jboss/jboss-remote-naming/2.0.4.Final-redhat-1/jboss-remote-naming-2.0.4.Final-redhat-1.jar
EJB=/home/rick/.m2/repository/org/jboss/jboss-ejb-client/2.0.0.Final/jboss-ejb-client-2.0.0.Final.jar
MARSHAL1=/home/rick/.m2/repository/org/jboss/marshalling/jboss-marshalling/1.4.3.Final/jboss-marshalling-1.4.3.Final.jar
MARSHAL2=/home/rick/.m2/repository/org/jboss/marshalling/jboss-marshalling-river/1.4.3.Final/jboss-marshalling-river-1.4.3.Final.jar
XNIO_OPTIONS=/home/rick/.m2/repository/org/jboss/xnio/xnio-api/3.2.0.Final/xnio-api-3.2.0.Final.jar
REMOTE_NAMING2=/home/rick/.m2/repository/org/jboss/remoting/jboss-remoting/4.0.0.Final/jboss-remoting-4.0.0.Final.jar
SASL=/home/rick/.m2/repository/org/jboss/sasl/jboss-sasl/1.0.4.Final/jboss-sasl-1.0.4.Final.jar
LOGGER=/home/rick/.m2/repository/org/jboss/logging/jboss-logging/3.1.4.GA/jboss-logging-3.1.4.GA.jar
XNIO=/home/rick/.m2/repository/org/jboss/xnio/xnio-nio/3.2.0.Final/xnio-nio-3.2.0.Final.jar
HQ_CLIENT=/home/rick/.m2/repository/org/hornetq/hornetq-jms-client/2.3.25.Final-redhat-1/hornetq-jms-client-2.3.25.Final-redhat-1.jar
HQ_CORE=/home/rick/.m2/repository/org/hornetq/hornetq-core-client/2.3.25.Final-redhat-1/hornetq-core-client-2.3.25.Final-redhat-1.jar
HQ_COMMONS=/home/rick/.m2/repository/org/hornetq/hornetq-commons/2.3.25.Final-redhat-1/hornetq-commons-2.3.25.Final-redhat-1.jar
HQ_JOURNAL=/home/rick/.m2/repository/org/hornetq/hornetq-journal/2.3.25.Final-redhat-1/hornetq-journal-2.3.25.Final-redhat-1.jar
JGROUPS=/home/rick/.m2/repository/org/jgroups/jgroups/3.2.13.Final/jgroups-3.2.13.Final.jar
NETTY=/home/rick/.m2/repository/io/netty/netty/3.6.10.Final/netty-3.6.10.Final.jar
JMS_API=/home/rick/.m2/repository/org/jboss/spec/javax/jms/jboss-jms-api_1.1_spec/1.0.0.Final/jboss-jms-api_1.1_spec-1.0.0.Final.jar


CP=$REMOTE_NAMING:$REMOTE_NAMING2:$XNIO:$XNIO_OPTIONS:$HQ_CLIENT:$JMS_API:$LOGGER:$EJB:$MARSHAL1:$MARSHAL2:$SASL:$HQ_CORE:$JGROUPS:$HQ_COMMONS:$HQ_JOURNAL:$NETTY

java -classpath $CP:./target/plain_jms_client-0.0.1-SNAPSHOT.jar org.sample.runloop.RunBoth
