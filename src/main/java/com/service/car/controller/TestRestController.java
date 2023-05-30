package com.service.car.controller;

import io.micrometer.core.annotation.Counted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class TestRestController {

    @Counted
    @GetMapping
    public ResponseEntity<List<String>> get() {
        List<String> list = new ArrayList<>();
        list.add("value 1");
        list.add("value 2");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
