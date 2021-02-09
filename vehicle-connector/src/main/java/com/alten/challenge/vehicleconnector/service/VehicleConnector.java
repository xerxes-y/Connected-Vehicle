package com.alten.challenge.vehicleconnector.service;

import com.alten.challenge.vehicleconnector.dto.VehicleStatusReceiverDto;

public interface VehicleConnector {
    void saveDriverStatus(VehicleStatusReceiverDto vehicleStatus);
}
