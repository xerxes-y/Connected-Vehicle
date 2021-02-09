package com.alten.challenge.vehicleconnector.config;

import com.alten.challenge.vehicleconnector.stream.VehicleConnectedStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(value = VehicleConnectedStream.class)
public class VehicleStreamingConfig {
}
