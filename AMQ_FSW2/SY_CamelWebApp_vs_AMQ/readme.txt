
This kit contains:

- A 'fixed' standalone-full.xml that will connect to an external A-MQ broker.  Note how the queues are declared.  
-- (In the A-MQ console ActiveMQ tree, these show as: (letters icon 'amq') (Sub-icon letter 'Queue') (Individual icons each for) ***REMOVED***orks.KPI.service.in, ***REMOVED***orks.matching.DoneMWEvent

- A Camel webapp that uses a timer to stick a message in a queue
- A SwitchYard app that reads from that queue, uses 'ReplyTo' to write out to a second queue
- The second queue is read from a route also in the Camel Webapp
- A utility web application used to prove the ConnectionFactory works, etc. without SY or Camel in play
