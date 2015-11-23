package org.sample.A_REST_wBASICAUTH_SY;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
public interface ExternalSvcCallerResource {
	
    @GET
    @Path("greet/{recipient}")
    @Consumes({"text/xml"})
	public String callExternalSvc(@PathParam("recipient") String recipient);

}
