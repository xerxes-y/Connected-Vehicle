package com.alten.challenge.vehicleconnector.service;

import com.alten.challenge.vehicleconnector.dto.CustomerDto;
import com.alten.challenge.vehicleconnector.dto.VehicleDto;
import com.alten.challenge.vehicleconnector.dto.VehicleStatusReceiverDto;
import com.alten.challenge.vehicleconnector.model.StatusDetailReceiver;
import reactor.core.publisher.Flux;

public interface VehicleService {
    Flux<VehicleStatusReceiverDto> streamVehicleStatus();
    Flux<VehicleStatusReceiverDto> getCustomerVehicle(String name);
    Flux<CustomerDto> getAllCustomers();
    Flux<VehicleDto> getAllVehicles();
    Flux<VehicleDto> getVehiclesWithSpecificStatus(StatusDetailReceiver statusDetail);
}
