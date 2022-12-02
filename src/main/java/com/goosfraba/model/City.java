package com.goosfraba.model;

import jakarta.persistence.*;

@Entity
@Embeddable
public class City {
    @Id
    private String id;
    @Column(length = 256)
    private String name;
    @Column(length = 4)
    private String code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}