package com.baku.akka.business.actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.baku.akka.business.messages.XMLMessage;

public class XMLMessageHandler extends AbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    static public Props props() {
        return Props.create(XMLMessageHandler.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(XMLMessage.class, msg -> {
                    log.info("XMLMessageHandler got XMLMessage - " + msg.getMessage());
                })
                .build();
    }
}
