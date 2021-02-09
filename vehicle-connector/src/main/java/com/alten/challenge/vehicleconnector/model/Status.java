package com.alten.challenge.vehicleconnector.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Status {
    @Id
    private String id;
    private String vin;
    private String customerId;
    private int driverId;
    private int ping;
    private Data time;
    private StatusDetailReceiver statusDetail;

}
