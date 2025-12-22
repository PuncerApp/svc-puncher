package com.puncher.puncher_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "punchers")
public class Puncher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String distance;

    // getters & setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getDistance() { return distance; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setDistance(String distance) { this.distance = distance; }
}
