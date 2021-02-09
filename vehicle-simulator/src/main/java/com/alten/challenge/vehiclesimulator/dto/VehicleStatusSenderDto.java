package com.alten.challenge.vehiclesimulator.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@JsonIgnoreProperties
public class VehicleStatusSenderDto implements Serializable {
    private String vin;
    private String customerId;
    private int driverId;
    private boolean connected;
    private int ping;
    private StatusDetailSender statusDetailDto;
}
