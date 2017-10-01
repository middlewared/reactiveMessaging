package com.baku.akka.business;

import akka.actor.ActorRef;
import static akka.actor.ActorRef.noSender;
import akka.actor.ActorSystem;
import com.baku.akka.business.actors.MessageBroker;
import com.baku.akka.business.actors.MessageReceiver;
import com.baku.akka.business.actors.StringMessageHandler;
import com.baku.akka.business.actors.XMLMessageHandler;
import com.baku.akka.business.messages.StringMessage;
import com.baku.akka.business.messages.XMLMessage;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class AkkaStarter {

    private ActorSystem system;

    @PostConstruct
    public void init() {
        system = ActorSystem.create("incomingMessageHandlerSystem");
        final ActorRef stringMessageHandler = system.actorOf(StringMessageHandler.props());
        final ActorRef xmlMessageHandler = system.actorOf(XMLMessageHandler.props());
        final ActorRef messageBroker = system.actorOf(MessageBroker.props(stringMessageHandler, xmlMessageHandler), "messageBroker");
        final ActorRef messageReceiver = system.actorOf(MessageReceiver.props(messageBroker), "messageReceiver");

        messageReceiver.tell(new XMLMessage("<tag>this is XML message</tag>"), noSender());
        messageReceiver.tell(new StringMessage("Simple string message"), noSender());
    }

    public void shutdown() {
        system.terminate();
    }
}
