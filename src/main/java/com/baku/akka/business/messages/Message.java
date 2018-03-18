package com.baku.akka.business.messages;

public abstract class Message {
    
    protected String payload;

    public String getPayload() {
        return payload;
    }
}
