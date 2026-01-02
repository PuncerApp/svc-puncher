package com.puncher.puncher_backend.owner;

import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/owners")
@CrossOrigin("*")
public class OwnerController {

    private final OwnerService service;
    private final OwnerRepository repo;

    public OwnerController(OwnerService service, OwnerRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    // REGISTER
    @PostMapping("/register")
    public Owner register(@RequestBody Owner owner) {
        return service.register(owner);
    }

    @GetMapping("/by-mobile/{mobile}")
    public Owner getByMobile(@PathVariable String mobile) {
        return service.getByMobile(mobile).orElse(null);
    }

    // OWNER SELF
    @GetMapping("/me")
    public Owner getMyProfile(Authentication auth) {
        Long ownerId = Long.valueOf(auth.getName());
        return repo.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
    }

    // ✅ ADMIN – LIST
    @GetMapping
    public List<Owner> getAllOwners() {
        return service.getAll();
    }

    // ✅ ADMIN – GET BY ID (🔥 THIS FIX)
    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable Long id) {
        return service.getOwnerById(id);
    }

    // ADMIN – UPDATE STATUS
    @PutMapping("/{id}/status/{status}")
    public Owner updateStatus(@PathVariable Long id,
                              @PathVariable OwnerStatus status) {
        return service.updateStatus(id, status);
    }

    // 🔐 ADMIN - DELETE OWNER
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable Long id) {
        service.deleteOwner(id);
        return ResponseEntity.ok("Owner deleted successfully");
    }
}