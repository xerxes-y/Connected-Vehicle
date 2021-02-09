package com.alten.challenge.vehiclesimulator.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan("com.alten.challenge.vehiclesimulator.scheduling")
public class ScheduledConfig {
}
