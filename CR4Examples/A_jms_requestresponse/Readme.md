This example shows how the Camel JMS component can be used for JMS request/response processing.

The primary parts are:

HQClient, a HornetQ standalone client.  This sends several messages (configurable) so you can validate correlation 
of the request/response messages.

GreetingService - A SwitchYard Service that listens on a JMS queue, the same queue HQClient sends a request to.
GreetingService makes use of another SwitchYard Service, NameEnhancer to add content to an input name.

NameEnhancer is the service that is invoked in a request/response manner.  Note that GreetingService calls it through
JMS, it provides a response.

Necessary Infrastructure:
Your server needs to have 2 queues defined, GreetingServiceQueue and GreetingServiceQueue1.  
Your server needs to have a HornetQ ConnectionFactory named "#ConnectionFactory".