package org.flyingdog.services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.flyingdog.model.Member;

@Path("/member")
public interface MemberResource {

    @POST
    @Path("/")
    // @Produces({"text/xml"})
    @Produces(MediaType.APPLICATION_JSON)
    public Member fetchMember();
    
    
    
    
}
