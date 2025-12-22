package com.puncher.puncher_backend.repository;

import com.puncher.puncher_backend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}