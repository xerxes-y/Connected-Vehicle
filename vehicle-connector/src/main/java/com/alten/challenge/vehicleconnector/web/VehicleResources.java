package com.alten.challenge.vehicleconnector.web;

import com.alten.challenge.vehicleconnector.dto.VehicleStatusReceiverDto;
import com.alten.challenge.vehicleconnector.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/vehicle-value")
@RequiredArgsConstructor
public class VehicleResources {
    private final VehicleService vehicleService;
    @GetMapping(value = "/get-all-vehicle",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<VehicleStatusReceiverDto> StreamAllVehicleStatus(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return vehicleService.streamVehicleStatus().delayElements(Duration.ofMinutes(1));

    }
    @GetMapping("/get-customer-vehicle")
    public Flux<VehicleStatusReceiverDto> getCustomerVehicle(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return vehicleService.streamVehicleStatus();

    }
}
