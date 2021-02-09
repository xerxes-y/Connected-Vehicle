package com.alten.challenge.vehicleconnector.service;

import com.alten.challenge.vehicleconnector.dto.VehicleStatusDto;

public interface VehicleConnector {
    void saveDriverStatus(VehicleStatusDto vehicleStatus);
}
