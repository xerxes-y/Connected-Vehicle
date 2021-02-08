package com.alten.challenge.service;

import com.alten.challenge.dto.VehicleStatusDto;

public interface VehicleConnector {
    void saveDriverStatus(VehicleStatusDto vehicleStatus);
}
