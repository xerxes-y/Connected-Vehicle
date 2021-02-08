package com.alten.challenge.service;

import com.alten.challenge.dto.CustomerDto;
import com.alten.challenge.dto.VehicleDto;
import com.alten.challenge.dto.VehicleStatusDto;
import org.apache.kafka.common.protocol.types.Field;
import reactor.core.publisher.Flux;

public interface VehicleService {
    Flux<VehicleStatusDto> streamVehicleStatus();
    Flux<VehicleStatusDto> getCustomerVehicle(String name);
    Flux<CustomerDto> getCustomers();
    Flux<VehicleDto> getVehicles();
}
