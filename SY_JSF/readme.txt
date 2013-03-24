This was tougher to implement than I expected.

This one was built using a JSF/CDI example as a starting point, then adding Switchyard through Project Facets. 

There was an error that was hard to find:
.....
Caused by: org.switchyard.component.bean.BeanComponentException: A service reference to service 'FrameSvc' is not bound into this client proxy instance.  A reference configuration to the service may be required in the application configuration.

The log seemed to be saying that the Switchyard proxy didn't have the reference, even though I had specified @Inject and @Reference.

Finally, highlighted @Reference annotation, JBDS/Eclipse gave me hints.  This one cured the problem:
@Inject @Named("frameSvcBean") private FrameSvc frameSvc;


