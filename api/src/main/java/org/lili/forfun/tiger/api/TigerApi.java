package org.lili.forfun.tiger.api;

import lombok.extern.log4j.Log4j2;
import org.lili.forfun.tiger.service.TigerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Component
@Path("tiger")
@Log4j2
public class TigerApi {
    @Autowired
    private TigerService tigerService;

    @POST
    @Path("request")
    @Produces(MediaType.APPLICATION_JSON)
    public String request(String request) {
        return tigerService.request(request);
    }
}