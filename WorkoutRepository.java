package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    // Basic CRUD operations (save, findById, findAll, deleteById) are provided automatically.
}