package com.puncher.puncher_backend.security;

import com.puncher.puncher_backend.owner.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/owner-auth")
@CrossOrigin("*")
public class OwnerAuthController {

    private final OwnerRepository repo;
    private final JwtUtil jwtUtil;

    private final Map<String, String> otpStore = new HashMap<>();

    public OwnerAuthController(OwnerRepository repo, JwtUtil jwtUtil) {
        this.repo = repo;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/send-otp")
    public Map<String, String> sendOtp(@RequestBody Map<String, String> req) {

        System.out.println("🔥 SEND OTP HIT");
        System.out.println("Headers OK, mobile = " + req.get("mobile"));

        otpStore.put(req.get("mobile"), "123456");
        return Map.of("message", "OTP sent");
    }

    @PostMapping("/verify-otp")
    public Map<String, Object> verifyOtp(@RequestBody Map<String, String> req) {

        String mobile = req.get("mobile");

        return repo.findByMobile(mobile)
                .map(owner -> {
                    String token = jwtUtil.generateToken(
                            owner.getId().toString(),
                            "OWNER"
                    );

                    return Map.<String, Object>of(
                            "type", "EXISTING",
                            "status", owner.getStatus(), // 👈 KEY POINT
                            "token", token
                    );
                })
                .orElse(Map.<String, Object>of(
                        "type", "NEW"
                ));
    }

}
