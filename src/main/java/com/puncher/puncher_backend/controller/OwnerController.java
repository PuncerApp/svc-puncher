package com.puncher.puncher_backend.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController("ownerSelfController")
@RequestMapping("/api/owner")
public class OwnerController {

    @GetMapping("/profile")
    public String getOwnerProfile(Authentication authentication) {
        // JWT-la irundhu varra username
        String username = authentication.getName();
        return "OWNER profile for: " + username;
    }

    @GetMapping("/dashboard")
    public String ownerDashboard(Authentication authentication) {
        return "Welcome OWNER 🔧 : " + authentication.getName();
    }
}
