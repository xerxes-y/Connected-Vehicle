package com.alten.challenge.service.imp;

import com.alten.challenge.dto.CustomerDto;
import com.alten.challenge.dto.VehicleDto;
import com.alten.challenge.dto.VehicleStatusDto;
import com.alten.challenge.model.Customer;
import com.alten.challenge.repository.CustomersRepository;
import com.alten.challenge.repository.StatusRepository;
import com.alten.challenge.repository.VehiclesRepository;
import com.alten.challenge.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service("vehicleConnectorImp")
@RequiredArgsConstructor
@Slf4j
public class VehicleServiceImpl implements VehicleService {
    private final StatusRepository statusRepository;
    private final CustomersRepository customersRepository;
    private final VehiclesRepository vehiclesRepository;

    @Override
    public Flux<VehicleStatusDto> streamVehicleStatus() {
        return vehiclesRepository.findAll().flatMap(vehicle -> {
            return statusRepository.findTopByVin(vehicle.getVin()).map(status -> {
                VehicleStatusDto vs = new VehicleStatusDto();
                vs.setConnected(status.isConnected());
                vs.setCustomerId(status.getCustomerId());
                vs.setDriverId(status.getDriverId());
                vs.setPing(status.getPing());
                vs.setVin(status.getVin());
                return vs;
            });
        });
    }

    @Override
    public Flux<VehicleStatusDto> getCustomerVehicle(String name) {
        return customersRepository.findByFullName(name).flatMapMany(customer -> {
            return statusRepository.findByCustomerId(customer.getId()).map(status -> {
                VehicleStatusDto vs = new VehicleStatusDto();
                vs.setConnected(status.isConnected());
                vs.setCustomerId(status.getCustomerId());
                vs.setDriverId(status.getDriverId());
                vs.setPing(status.getPing());
                vs.setVin(status.getVin());
                return vs;
            });
        });
    }

    @Override
    public Flux<CustomerDto> getCustomers() {
        return customersRepository.findAll().map(customer -> {
            CustomerDto cd = new CustomerDto();
            cd.setAddress(customer.getAddress());
            cd.setFullName(customer.getFullName());
            cd.setId(customer.getId());
            return cd;
        });
    }

    @Override
    public Flux<VehicleDto> getVehicles() {
       return vehiclesRepository.findAll().map(vehicle -> {
            VehicleDto vehicleDto = new VehicleDto();
            vehicleDto.setCustomerId(vehicle.getCustomerId());
            vehicleDto.setId(vehicle.getId());
            vehicleDto.setVin(vehicle.getVin());
            return vehicleDto;
        });
    }
}
