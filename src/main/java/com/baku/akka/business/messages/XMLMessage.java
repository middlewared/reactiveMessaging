package com.baku.akka.business.messages;

public class XMLMessage extends Message {

    private final String message;

    public XMLMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
