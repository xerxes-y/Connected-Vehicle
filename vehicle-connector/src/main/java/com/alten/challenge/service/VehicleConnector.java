package com.alten.challenge.service;

import com.alten.challenge.dto.VehicleStatus;

public interface VehicleConnector {
    void saveDriverStatus(VehicleStatus vehicleStatus);
}
