package com.alten.challenge.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Vehicle {
    private String vin;
    private String regNr;
}
