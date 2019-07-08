package org.lili.forfun.tiger.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Component
@Path("/")
@Log4j2
public class TigerOpsApi {

    @GET
    @Path("health")
    @Produces(MediaType.TEXT_PLAIN)
    public String health() {
        return "OK";
    }
}
