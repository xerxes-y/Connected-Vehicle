package com.alten.challenge.vehiclesimulator.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Customer {
    @Id
    private String id;
    private String fullName;
    private String address;
}
