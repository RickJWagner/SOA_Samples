Edit your configuration (maybe standalone-full.xml so it includes the queue we need:
 <jms-destinations>
                    <jms-queue name="testQueue">
                        <entry name="queue/test"/>
                        <entry name="java:jboss/exported/jms/queue/test"/>
                    </jms-queue>
                    <jms-queue name="fdq1">
                        <entry name="queue/fdq1"/>
                        <entry name="java:jboss/exported/jms/queue/fdq1"/>
                    </jms-queue>


The JMS project includes a sample MDB to prove we can consume from a queue, and a servlet that pops a message onto the queue.
Invoke the servlet like this, passing an arg:  
http://localhost:8080/SY_JMS_HelperWebApp/JMSClient?myarg=Hooha


The Switchyard project consumes from the queue.
