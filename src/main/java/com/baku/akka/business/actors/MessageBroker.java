package com.baku.akka.business.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import static akka.actor.ActorRef.noSender;
import akka.actor.Props;
import com.baku.akka.business.messages.StringMessage;
import com.baku.akka.business.messages.XMLMessage;

public class MessageBroker extends AbstractActor {

    private final ActorRef stringMessageHandler;
    private final ActorRef xmlMessageHandler;
    
    static public Props props(ActorRef stringMessageHandler, ActorRef xmlMessageHandler) {
        return Props.create(MessageBroker.class, () -> new MessageBroker(stringMessageHandler, xmlMessageHandler));
    }

    public MessageBroker(ActorRef stringMessageHandler, ActorRef xmlMessageHandler) {
        this.stringMessageHandler = stringMessageHandler;
        this.xmlMessageHandler = xmlMessageHandler;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(XMLMessage.class, message -> {
                    xmlMessageHandler.tell(message, noSender());
                })
                .match(StringMessage.class, message -> {
                    stringMessageHandler.tell(message, noSender());
                })
                .build();
    }
}
