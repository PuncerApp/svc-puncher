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

    // ✅ ENUMS
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;   // BIKE / CAR / BOTH

    @Enumerated(EnumType.STRING)
    private ShopType shopType;         // MECHANIC / PUNCHER / BOTH

    // ✅ PUNCHER OPTIONS
    private Boolean tube;
    private Boolean tubeless;
    private Boolean air;

    @Enumerated(EnumType.STRING)
    private OwnerStatus status;

    // ===== GETTERS / SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public VehicleType getVehicleType() { return vehicleType; }
    public void setVehicleType(VehicleType vehicleType) { this.vehicleType = vehicleType; }

    public ShopType getShopType() { return shopType; }
    public void setShopType(ShopType shopType) { this.shopType = shopType; }

    public Boolean getTube() { return tube; }
    public void setTube(Boolean tube) { this.tube = tube; }

    public Boolean getTubeless() { return tubeless; }
    public void setTubeless(Boolean tubeless) { this.tubeless = tubeless; }

    public Boolean getAir() { return air; }
    public void setAir(Boolean air) { this.air = air; }

    public OwnerStatus getStatus() { return status; }
    public void setStatus(OwnerStatus status) { this.status = status; }
}
