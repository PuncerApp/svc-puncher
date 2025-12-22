package com.puncher.puncher_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceType;
    private String puncherName;
    private String phone;
    private String status;

    public Long getId() {
        return id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getPuncherName() {
        return puncherName;
    }

    public String getPhone() {
        return phone;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setPuncherName(String puncherName) {
        this.puncherName = puncherName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
