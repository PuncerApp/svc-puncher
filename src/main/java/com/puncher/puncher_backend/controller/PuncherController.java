package com.puncher.puncher_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/punchers")
public class PuncherController {

    @GetMapping
    public List<Map<String, Object>> getPunchers() {
        return List.of(
                Map.of(
                        "id", 1,
                        "name", "Ravi",
                        "phone", "9876543210",
                        "distance", "2km"
                ),
                Map.of(
                        "id", 2,
                        "name", "Kumar",
                        "phone", "9123456789",
                        "distance", "3km"
                )
        );
    }
}
