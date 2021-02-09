package com.alten.challenge.vehicleconnector.service.imp;
import com.alten.challenge.vehicleconnector.dto.VehicleStatusReceiverDto;
import com.alten.challenge.vehicleconnector.model.Status;
import com.alten.challenge.vehicleconnector.repository.StatusRepository;
import com.alten.challenge.vehicleconnector.service.VehicleConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
@Service("vehicleConnectorImpl")
@RequiredArgsConstructor
@Slf4j
public class VehicleConnectorImpl implements VehicleConnector {
    private final StatusRepository statusRepository;
    @Override
    public void saveDriverStatus(VehicleStatusReceiverDto vehicleStatus) {
    Status status = new Status();
    status.setStatusDetail(vehicleStatus.getStatusDetailDto());
    status.setCustomerId(vehicleStatus.getCustomerId());
    status.setDriverId(vehicleStatus.getDriverId());
    status.setPing(vehicleStatus.getPing());
    status.setVin(vehicleStatus.getVin());
    statusRepository.save(status).subscribe();
    }
}
