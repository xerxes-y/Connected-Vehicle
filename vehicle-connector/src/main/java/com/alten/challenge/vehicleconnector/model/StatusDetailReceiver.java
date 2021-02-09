package com.alten.challenge.vehicleconnector.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class StatusDetailReceiver implements Serializable {
    private boolean connected;
    private boolean openDoor;
    private boolean runEngine;
    private int gas;
    private int speedKilometers;
    private int wheelsWind;
}
