package com.alten.challenge.config;


import com.alten.challenge.stream.VehicleConnectedStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding({VehicleConnectedStream.class})
public class StreamsConfig {
}
