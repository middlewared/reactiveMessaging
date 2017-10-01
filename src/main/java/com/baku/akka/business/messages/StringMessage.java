package com.baku.akka.business.messages;

public class StringMessage extends Message {

    private final String message;

    public StringMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
