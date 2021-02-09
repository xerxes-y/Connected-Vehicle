package com.alten.challenge.vehicleconnector.service.imp;
import com.alten.challenge.vehicleconnector.dto.VehicleStatusDto;
import com.alten.challenge.vehicleconnector.model.Status;
import com.alten.challenge.vehicleconnector.repository.StatusRepository;
import com.alten.challenge.vehicleconnector.service.VehicleConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
@Service("vehicleConnectorImp")
@RequiredArgsConstructor
@Slf4j
public class VehicleConnectorImp implements VehicleConnector {
    private final StatusRepository statusRepository;
    @Override
    public void saveDriverStatus(VehicleStatusDto vehicleStatus) {
    Status status = new Status();
    status.setConnected(vehicleStatus.isConnected());
    status.setCustomerId(vehicleStatus.getCustomerId());
    status.setDriverId(vehicleStatus.getDriverId());
    status.setPing(vehicleStatus.getPing());
    status.setVin(vehicleStatus.getVin());
    statusRepository.save(status).subscribe();
    }
}
