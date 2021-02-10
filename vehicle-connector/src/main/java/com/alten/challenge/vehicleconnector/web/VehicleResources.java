package com.alten.challenge.vehicleconnector.web;

import com.alten.challenge.vehicleconnector.dto.VehicleDto;
import com.alten.challenge.vehicleconnector.dto.VehicleStatusReceiverDto;
import com.alten.challenge.vehicleconnector.model.StatusDetailReceiver;
import com.alten.challenge.vehicleconnector.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/get-customer-vehicle/{customerName}")
    public Flux<VehicleStatusReceiverDto> getCustomerVehicle(@PathVariable String customerName) {
        return vehicleService.getCustomerVehicle(customerName);

    }

    @GetMapping("/get-vehicle-with-status")
    public Flux<VehicleDto> getCustomerVehicle(@RequestParam int speedKilometer,@RequestParam Boolean openDoor) {
        return vehicleService.getVehiclesWithSpecificStatus(speedKilometer,openDoor);

    }
}
