package com.alten.challenge.vehicleconnector.stream;


import com.alten.challenge.vehicleconnector.dto.VehicleStatusDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class VehicleConnectorListener {

    private final com.alten.challenge.vehicleconnector.service.VehicleConnector VehicleConnector;

    @StreamListener(VehicleConnectedStream.VEHICLE_CONNECTOR)
    public void handleOrderUpdate(@Payload Message<VehicleStatusDto> message) {
        VehicleStatusDto vehicleStatus = message.getPayload();
        log.info("received payload from vehicle simulator: {}", vehicleStatus);
        VehicleConnector.saveDriverStatus(vehicleStatus);
    }

}
