
Include this in standalone-full.xml

                <jms-destinations>
                    <jms-queue name="testq1">
                        <entry name="queue/testq1"/>
                        <entry name="java:jboss/exported/jms/queue/testq1"/>
                    </jms-queue>
                </jms-destinations>
            </hornetq-server>

