package com.puncher.puncher_backend.owner;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/owners")
@CrossOrigin("*")
public class OwnerController {

    private final OwnerService service;

    public OwnerController(OwnerService service) {
        this.service = service;
    }

    // Web Owner App
    @PostMapping("/register")
    public Owner register(@RequestBody Owner owner) {
        return service.register(owner);
    }

    @GetMapping("/by-mobile/{mobile}")
    public Owner getByMobile(@PathVariable String mobile) {
        return service.getByMobile(mobile).orElse(null);
    }

    // Admin Panel
    @GetMapping
    public List<Owner> getAllOwners() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable Long id) {
        return service.getOwnerById(id);
    }

    @PutMapping("/{id}/status/{status}")
    public Owner updateStatus(@PathVariable Long id, @PathVariable String status) {
        return service.updateStatus(id, status);
    }
}
