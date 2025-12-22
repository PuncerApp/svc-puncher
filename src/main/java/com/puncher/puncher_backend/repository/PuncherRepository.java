package com.puncher.puncher_backend.repository;

import com.puncher.puncher_backend.model.Puncher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuncherRepository extends JpaRepository<Puncher, Long> {
}
