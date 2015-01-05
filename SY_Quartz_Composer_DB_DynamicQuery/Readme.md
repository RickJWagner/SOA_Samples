Demonstrates:

- Using a quartz input (with custom composer to set the message)
- A ServiceBean that gets the request and goes to a database to get information
- Using a ReferenceInvoker to dynamically set the query for the DB depending on the message sent.  (It does this with a Camel property set with the ReferenceInvoker.)
