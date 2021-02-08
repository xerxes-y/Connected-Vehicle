package com.alten.challenge.service;

import com.alten.challenge.dto.CustomerDto;
import com.alten.challenge.dto.VehicleDto;
import com.alten.challenge.dto.VehicleStatusDto;
import com.alten.challenge.model.StatusDetail;
import reactor.core.publisher.Flux;

public interface VehicleService {
    Flux<VehicleStatusDto> streamVehicleStatus();
    Flux<VehicleStatusDto> getCustomerVehicle(String name);
    Flux<CustomerDto> getAllCustomers();
    Flux<VehicleDto> getAllVehicles();
    Flux<VehicleDto> getVehiclesWithSpecificStatus(StatusDetail statusDetail);
}
