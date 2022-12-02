package com.goosfraba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityParkController {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

}
