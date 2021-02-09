package com.alten.challenge.vehiclesimulator.stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface VehicleConnectedStream {
    String VEHICLE_CONNECTOR = "vehicle-stream";

    @Output(VEHICLE_CONNECTOR)
    MessageChannel getChannel();
}
