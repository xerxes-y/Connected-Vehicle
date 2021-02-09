package com.alten.challenge.vehicleconnector.service.imp;

import com.alten.challenge.vehicleconnector.dto.CustomerDto;
import com.alten.challenge.vehicleconnector.dto.VehicleDto;
import com.alten.challenge.vehicleconnector.dto.VehicleStatusReceiverDto;
import com.alten.challenge.vehicleconnector.model.StatusDetailReceiver;
import com.alten.challenge.vehicleconnector.repository.CustomersRepository;
import com.alten.challenge.vehicleconnector.repository.StatusRepository;
import com.alten.challenge.vehicleconnector.repository.VehiclesRepository;
import com.alten.challenge.vehicleconnector.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public Flux<VehicleStatusReceiverDto> streamVehicleStatus() {
        return vehiclesRepository.findAll().flatMap(vehicle -> {
            return customersRepository.findById(vehicle.getCustomerId()).flatMap(customer -> {
                return statusRepository.findTopByVin(vehicle.getVin()).map(status -> {
                    VehicleStatusReceiverDto vs = new VehicleStatusReceiverDto();
                    vs.setCustomerId(customer.getId());
                    vs.setCustomerName(customer.getFullName());
                    vs.setDriverId(status.getDriverId());
                    vs.setPing(status.getPing());
                    vs.setVin(status.getVin());
                    StatusDetailReceiver statusDetailDto = new StatusDetailReceiver();
                    statusDetailDto.setConnected(status.getStatusDetail().isConnected());
                    statusDetailDto.setGas(status.getStatusDetail().getGas());
                    statusDetailDto.setOpenDoor(status.getStatusDetail().isOpenDoor());
                    statusDetailDto.setRunEngine(status.getStatusDetail().isRunEngine());
                    statusDetailDto.setSpeedKilometers(status.getStatusDetail().getSpeedKilometers());
                    statusDetailDto.setWheelsWind(status.getStatusDetail().getWheelsWind());
                    vs.setStatusDetailDto(statusDetailDto);
                    return vs;
                });
            });
        });
    }

    @Override
    public Flux<VehicleStatusReceiverDto> getCustomerVehicle(String name) {
        return customersRepository.findByFullNameStartingWith(name).flatMapMany(customer -> {
            return vehiclesRepository.findByCustomerId(customer.getId()).flatMap(vehicle -> {
                return statusRepository.findTopByVin(vehicle.getVin()).map(status -> {
                    VehicleStatusReceiverDto vs = new VehicleStatusReceiverDto();
                    vs.setCustomerId(customer.getId());
                    vs.setCustomerName(customer.getFullName());
                    vs.setDriverId(status.getDriverId());
                    vs.setPing(status.getPing());
                    vs.setVin(status.getVin());
                    StatusDetailReceiver statusDetailDto = new StatusDetailReceiver();
                    statusDetailDto.setConnected(status.getStatusDetail().isConnected());
                    statusDetailDto.setGas(status.getStatusDetail().getGas());
                    statusDetailDto.setOpenDoor(status.getStatusDetail().isOpenDoor());
                    statusDetailDto.setRunEngine(status.getStatusDetail().isRunEngine());
                    statusDetailDto.setSpeedKilometers(status.getStatusDetail().getSpeedKilometers());
                    statusDetailDto.setWheelsWind(status.getStatusDetail().getWheelsWind());
                    vs.setStatusDetailDto(statusDetailDto);
                    return vs;
                });
            });
        });
    }

    @Override
    public Flux<CustomerDto> getAllCustomers() {
        return customersRepository.findAll().map(customer -> {
            CustomerDto cd = new CustomerDto();
            cd.setAddress(customer.getAddress());
            cd.setFullName(customer.getFullName());
            cd.setId(customer.getId());
            return cd;
        });
    }

    @Override
    public Flux<VehicleDto> getAllVehicles() {
        return vehiclesRepository.findAll().map(vehicle -> {
            VehicleDto vehicleDto = new VehicleDto();
            vehicleDto.setCustomerId(vehicle.getCustomerId());
            vehicleDto.setId(vehicle.getId());
            vehicleDto.setVin(vehicle.getVin());
            return vehicleDto;
        });
    }

    @Override
    public Flux<VehicleDto> getVehiclesWithSpecificStatus(StatusDetailReceiver statusDetail) {
        return statusRepository.findByStatusDetail(statusDetail).flatMap(status -> {
            return vehiclesRepository.findByVin(status.getVin()).map(vehicle -> {
                VehicleDto vd = new VehicleDto();
                vd.setVin(vehicle.getVin());
                vd.setId(vehicle.getId());
                vd.setCustomerId(vehicle.getCustomerId());
                vd.setRegNr(vehicle.getRegNr());
                return vd;
            });
        });
    }


}
