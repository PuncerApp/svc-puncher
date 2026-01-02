package com.puncher.puncher_backend.owner;

import jakarta.persistence.*;

@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerName;
    private String shopName;
    private String mobile;
    private String email;
    private String address;

    private Double latitude;
    private Double longitude;

    private String vehicleType;
    private Boolean tube;
    private Boolean tubeless;
    private Boolean air;

    @Enumerated(EnumType.STRING)
    private OwnerStatus status;   // ✅ ONLY THIS

    // ===== GETTERS / SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public OwnerStatus getStatus() { return status; }
    public void setStatus(OwnerStatus status) { this.status = status; }
}
