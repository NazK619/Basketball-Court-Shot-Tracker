package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ShootingLog;

@Repository
public interface ShootingLogRepository extends JpaRepository<ShootingLog, Long> {
    
    // Custom query method derived from property names
    List<ShootingLog> findByWorkoutId(Long workoutId);
}