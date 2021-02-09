package com.alten.challenge.vehicleconnector.dto;

import com.alten.challenge.vehicleconnector.model.StatusDetailReceiver;
import lombok.Data;

import java.io.Serializable;

@Data
public class VehicleStatusReceiverDto implements Serializable {
    private String vin;
    private String customerId;
    private String customerName;
    private int driverId;
    private int ping;
    private StatusDetailReceiver statusDetailDto;

}
