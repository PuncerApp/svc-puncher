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

    // ✅ NEW OWNER → ALWAYS PENDING
    public Owner register(Owner owner) {

        // always pending
        owner.setStatus(OwnerStatus.PENDING);

        // if mechanic shop → no puncture options
        if (owner.getShopType() == ShopType.MECHANIC) {
            owner.setTube(false);
            owner.setTubeless(false);
            owner.setAir(false);
        }

        return repo.save(owner);
    }

    public Optional<Owner> getByMobile(String mobile) {
        return repo.findByMobile(mobile);
    }

    public List<Owner> getAll() {
        return repo.findAll();
    }

    // ✅ ADMIN UPDATE STATUS
    public Owner updateStatus(Long id, OwnerStatus status) {
        Owner owner = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        owner.setStatus(status);
        return repo.save(owner);
    }

    public Owner getOwnerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
    }

    // ✅ ADMIN DELETE OWNER
    public void deleteOwner(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Owner not found");
        }
        repo.deleteById(id);
    }
}
