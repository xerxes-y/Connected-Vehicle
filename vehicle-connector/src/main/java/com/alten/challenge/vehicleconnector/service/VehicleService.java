package com.alten.challenge.vehicleconnector.service;

import com.alten.challenge.vehicleconnector.dto.CustomerDto;
import com.alten.challenge.vehicleconnector.dto.VehicleDto;
import com.alten.challenge.vehicleconnector.dto.VehicleStatusDto;
import com.alten.challenge.vehicleconnector.model.StatusDetail;
import reactor.core.publisher.Flux;

public interface VehicleService {
    Flux<VehicleStatusDto> streamVehicleStatus();
    Flux<VehicleStatusDto> getCustomerVehicle(String name);
    Flux<CustomerDto> getAllCustomers();
    Flux<VehicleDto> getAllVehicles();
    Flux<VehicleDto> getVehiclesWithSpecificStatus(StatusDetail statusDetail);
}
