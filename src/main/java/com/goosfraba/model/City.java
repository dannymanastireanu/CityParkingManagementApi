package com.goosfraba.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Embeddable
public record City(
    @Id
    String id,
    @Column(length = 256)
    String name,
    @Column(length = 4)
    String code,
    @OneToMany
    List<ParkingFacilities> parkingFacilities
) {
}
