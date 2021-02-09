package com.alten.challenge.vehiclesimulator.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StatusDetailSender implements Serializable {
    private boolean connected;
    private boolean openDoor;
    private boolean runEngine;
    private int gas;
    private int speedKilometers;
    private int wheelsWind;
}
