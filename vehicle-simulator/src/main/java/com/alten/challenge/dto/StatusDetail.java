package com.alten.challenge.dto;

import lombok.Data;

@Data
public class StatusDetail {
    private boolean connected;
    private boolean openDoor;
    private boolean runEngine;
    private int gas;
    private int speedKilometers;
    private int wheelsWind;
}