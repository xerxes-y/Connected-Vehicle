package com.alten.challenge.vehiclesimulator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleStatus {
    private String vin;
    private String customerId;
    private int driverId;
    private boolean connected;
    private int ping;
    private StatusDetail statusDetail;
}
