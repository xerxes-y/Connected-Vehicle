package com.alten.challenge.config;

import com.alten.challenge.stream.VehicleConnectedStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(value = VehicleConnectedStream.class)
public class VehicleStreamingConfig {
}
