package com.example.demoUP.repository;

import com.example.demoUP.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Units
@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {}
