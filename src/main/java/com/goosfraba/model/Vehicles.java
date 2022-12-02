package com.goosfraba.model;

import jakarta.persistence.Embedded;

public abstract class Vehicles {
    String id;

    @Embedded
    City city;

//    @Embedded
    ParkingFacilities parkingFacilities;

    Boolean isParked;

}
