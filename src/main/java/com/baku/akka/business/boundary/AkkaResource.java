package com.baku.akka.business.boundary;

import com.baku.akka.business.AkkaStarter;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;

@Stateless
@Path("akka")
public class AkkaResource {

    @Inject
    AkkaStarter akkaStarter;

    @GET
    public void initActorSystem() {
        akkaStarter.init();
    }

    @DELETE
    public void shutdownActorSystem() {
        akkaStarter.shutdown();
    }
}
