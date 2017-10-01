package com.baku.akka.business.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import static akka.actor.ActorRef.noSender;
import akka.actor.Props;
import com.baku.akka.business.messages.Message;

public class MessageReceiver extends AbstractActor {

    private final ActorRef messageBroker;

    static public Props props(ActorRef messageBroker) {
        return Props.create(MessageReceiver.class, () -> new MessageReceiver(messageBroker));
    }

    public MessageReceiver(ActorRef messageBroker) {
        this.messageBroker = messageBroker;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Message.class, msg -> {
                    messageBroker.tell(msg, noSender());
                })
                .build();
    }
}
