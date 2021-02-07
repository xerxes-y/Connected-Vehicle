package com.alten.challenge.stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface VehicleConnectedStream {
    @Value("${spring.cloud.bindings.vehicle-streams.destination}")
    String KT_ORDER_CHANGE = "vehicle-stream";

    @Output(KT_ORDER_CHANGE)
    MessageChannel getChannel();
}
