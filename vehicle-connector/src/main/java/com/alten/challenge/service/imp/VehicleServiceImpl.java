package com.alten.challenge.service.imp;

import com.alten.challenge.dto.CustomerDto;
import com.alten.challenge.dto.VehicleDto;
import com.alten.challenge.dto.VehicleStatusDto;
import com.alten.challenge.model.StatusDetail;
import com.alten.challenge.model.Vehicle;
import com.alten.challenge.repository.CustomersRepository;
import com.alten.challenge.repository.StatusRepository;
import com.alten.challenge.repository.VehiclesRepository;
import com.alten.challenge.service.VehicleService;
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
    public Flux<VehicleStatusDto> streamVehicleStatus() {
        return vehiclesRepository.findAll().flatMap(vehicle -> {
            return statusRepository.findTopByVin(vehicle.getVin()).map(status -> {
                VehicleStatusDto vs = new VehicleStatusDto();
                vs.setCustomerId(status.getCustomerId());
                vs.setDriverId(status.getDriverId());
                vs.setPing(status.getPing());
                vs.setVin(status.getVin());
                StatusDetail statusDetailDto = new StatusDetail();
                statusDetailDto.setConnected(status.getStatusDetail().isConnected());
                statusDetailDto.setGas(status.getStatusDetail().getGas());
                statusDetailDto.setOpenDoor(status.getStatusDetail().isOpenDoor());
                statusDetailDto.setRunEngine(status.getStatusDetail().isRunEngine());
                statusDetailDto.setSpeedKilometers(status.getStatusDetail().getSpeedKilometers());
                statusDetailDto.setWheelsWind(status.getStatusDetail().getWheelsWind());
                return vs;
            });
        });
    }

    @Override
    public Flux<VehicleStatusDto> getCustomerVehicle(String name) {
        return customersRepository.findByFullName(name).flatMapMany(customer -> {
            return statusRepository.findByCustomerId(customer.getId()).map(status -> {
                VehicleStatusDto vs = new VehicleStatusDto();
                vs.setCustomerId(status.getCustomerId());
                vs.setDriverId(status.getDriverId());
                vs.setPing(status.getPing());
                vs.setVin(status.getVin());
                StatusDetail statusDetailDto = new StatusDetail();
                statusDetailDto.setConnected(status.getStatusDetail().isConnected());
                statusDetailDto.setGas(status.getStatusDetail().getGas());
                statusDetailDto.setOpenDoor(status.getStatusDetail().isOpenDoor());
                statusDetailDto.setRunEngine(status.getStatusDetail().isRunEngine());
                statusDetailDto.setSpeedKilometers(status.getStatusDetail().getSpeedKilometers());
                statusDetailDto.setWheelsWind(status.getStatusDetail().getWheelsWind());
                return vs;
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
    public Flux<VehicleDto> getVehiclesWithSpecificStatus(StatusDetail statusDetail) {
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
