package com.alten.challenge.vehicleconnector.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface VehicleConnectedStream {

    String VEHICLE_CONNECTOR = "vehicle-stream";

    @Input(VEHICLE_CONNECTOR)
    SubscribableChannel getChannel();

}
