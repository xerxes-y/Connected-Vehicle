package com.alten.challenge.vehiclesimulator.stream;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

@Component
@RequiredArgsConstructor
@Slf4j
public class VehicleChannelSender implements StreamMessageSender  {

    private final VehicleConnectedStream vehicleConnectedStream;

    @Override
    public void sentMessage(Object payloadMessage) {
        try {
            log.info("Sending payload: {}", payloadMessage.toString());
            MessageChannel channel = vehicleConnectedStream.getChannel();
            channel.send(MessageBuilder
                    .withPayload(payloadMessage)
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                    .build());
        } catch (Exception e) {
            log.info("put message on kafka failed with payload: {}", payloadMessage);
            log.error(e.getMessage(), e);
        }
        log.info("Successfully put message on kafka");
    }

}
