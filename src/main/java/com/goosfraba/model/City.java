package com.goosfraba.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Embeddable
@Data
public class City {
    @Id
    private String id;
    @Column(length = 256)
    private String name;
    @Column(length = 4)
    private String code;
}