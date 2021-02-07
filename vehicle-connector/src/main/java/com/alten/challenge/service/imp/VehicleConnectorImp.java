package com.alten.challenge.service.imp;
import com.alten.challenge.dto.VehicleStatus;
import com.alten.challenge.model.Status;
import com.alten.challenge.repository.StatusRepository;
import com.alten.challenge.service.VehicleConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
@Service("nonEtfDonyaOrderService")
@RequiredArgsConstructor
@Slf4j
public class VehicleConnectorImp implements VehicleConnector {
    private final StatusRepository statusRepository;
    @Override
    public void saveDriverStatus(VehicleStatus vehicleStatus) {
    Status status = new Status();
    status.setConnected(vehicleStatus.isConnected());
    status.setCustomerId(vehicleStatus.getCustomerId());
    status.setDriverId(vehicleStatus.getDriverId());
    status.setPing(vehicleStatus.getPing());
    status.setVin(vehicleStatus.getVin());
    statusRepository.save(status);
    }
}
