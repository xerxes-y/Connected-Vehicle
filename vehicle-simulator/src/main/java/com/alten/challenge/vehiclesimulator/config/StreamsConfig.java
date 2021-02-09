package com.alten.challenge.vehiclesimulator.config;


import com.alten.challenge.vehiclesimulator.stream.VehicleConnectedStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding({VehicleConnectedStream.class})
public class StreamsConfig {
}
