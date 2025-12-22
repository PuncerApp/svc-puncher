package com.puncher.puncher_backend.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @PostMapping
    public Map<String, Object> createBooking(@RequestBody Map<String, Object> request) {
        return Map.of(
                "message", "Booking created successfully",
                "data", request
        );
    }
}
