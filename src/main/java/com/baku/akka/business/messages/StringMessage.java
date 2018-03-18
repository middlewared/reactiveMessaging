package com.baku.akka.business.messages;

public class StringMessage extends Message {

    public StringMessage(String payload) {
        this.payload = payload;
    }
}
