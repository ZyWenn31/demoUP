package com.example.demoUP.repository;

import com.example.demoUP.model.PickupPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Pickup Points
@Repository
public interface PickupPointRepository extends JpaRepository<PickupPoint, Long> {}