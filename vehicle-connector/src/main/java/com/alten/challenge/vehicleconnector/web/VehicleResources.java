package com.alten.challenge.vehicleconnector.web;

import com.alten.challenge.vehicleconnector.dto.VehicleDto;
import com.alten.challenge.vehicleconnector.dto.VehicleStatusReceiverDto;
import com.alten.challenge.vehicleconnector.model.StatusDetailReceiver;
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
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class VehicleResources {
    private final VehicleService vehicleService;
    @GetMapping(value = "/get-all-vehicle",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<VehicleStatusReceiverDto> StreamAllVehicleStatus() {
        return Flux.interval(Duration.ofSeconds(1)).flatMap(duration -> vehicleService.streamVehicleStatus());

    }
    @GetMapping("/get-customer-vehicle")
    public Flux<VehicleStatusReceiverDto> getCustomerVehicle(String customerName) {
        return vehicleService.getCustomerVehicle(customerName);

    }

    @GetMapping("/get-vehicle-with-status")
    public Flux<VehicleDto> getCustomerVehicle(StatusDetailReceiver statusDetailReceiver) {
        return vehicleService.getVehiclesWithSpecificStatus(statusDetailReceiver);

    }
}
