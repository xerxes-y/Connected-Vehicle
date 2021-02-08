package com.alten.challenge.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class VehicleStatusDto implements Serializable {
    private String vin;
    private String customerId;
    private int driverId;
    private boolean connected;
    private int ping;
}
