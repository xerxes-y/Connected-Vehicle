package com.alten.challenge.vehicleconnector.dto;

import com.alten.challenge.vehicleconnector.model.StatusDetail;
import lombok.Data;

import java.io.Serializable;

@Data
public class VehicleStatusDto implements Serializable {
    private String vin;
    private String customerId;
    private int driverId;
    private int ping;
    private StatusDetail statusDetailDto;

}
