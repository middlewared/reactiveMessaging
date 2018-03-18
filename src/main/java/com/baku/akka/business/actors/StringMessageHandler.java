package com.baku.akka.business.actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.baku.akka.business.messages.StringMessage;

public class StringMessageHandler extends AbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    static public Props props() {
        return Props.create(StringMessageHandler.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(StringMessage.class, message -> {
                    log.info("StringMessageHandler got StringMessage - " + message.getPayload());
                })
                .build();
    }
}
