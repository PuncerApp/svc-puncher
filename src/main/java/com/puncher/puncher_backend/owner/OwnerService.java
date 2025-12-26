package com.puncher.puncher_backend.owner;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository repo;

    public OwnerService(OwnerRepository repo) {
        this.repo = repo;
    }

    public Owner register(Owner owner) {
        owner.setStatus("PENDING");
        return repo.save(owner);
    }

    public Optional<Owner> getByMobile(String mobile) {
        return repo.findByMobile(mobile);
    }

    public List<Owner> getAll() {
        return repo.findAll();
    }

    public Owner updateStatus(Long id, String status) {
        Owner owner = repo.findById(id).orElseThrow();
        owner.setStatus(status);
        return repo.save(owner);
    }

    public Owner getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Owner getOwnerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
    }
}
