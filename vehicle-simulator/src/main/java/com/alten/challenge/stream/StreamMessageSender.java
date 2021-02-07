package com.alten.challenge.stream;

public interface StreamMessageSender {

    void sentMessage(Object payloadMessage) throws RuntimeException;

}
