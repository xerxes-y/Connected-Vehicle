package com.alten.challenge.vehiclesimulator.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Vehicle {
    @Id
    private String id;
    private String vin;
    private String regNr;
    private String customerId;
    private boolean availability;
}
