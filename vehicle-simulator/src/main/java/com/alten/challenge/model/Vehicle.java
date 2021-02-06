package com.alten.challenge.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Vehicle {
    @Id
    private String id;
    private String vin;
    private String regNr;
    private String customerId;
}
