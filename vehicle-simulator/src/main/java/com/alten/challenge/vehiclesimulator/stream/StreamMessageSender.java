package com.alten.challenge.vehiclesimulator.stream;

public interface StreamMessageSender {

    void sentMessage(Object payloadMessage) throws RuntimeException;

}
