package com.example.demo.service;
import com.example.demo.model.Workout;
import com.example.demo.model.ShootingLog;
import com.example.demo.repository.WorkoutRepository;
import com.example.demo.repository.ShootingLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired 
    private WorkoutRepository workoutRepository;

    @Autowired 
    private ShootingLogRepository shootingLogRepository;

    //save a complete workout session
    public Workout saveWorkout(Workout workout){
        return workoutRepository.save(workout);
    }

    //get all recorded workouts
    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }
    
    //find a indiv workout from its ID
    public Optional<Workout> getWorkoutById(Long id){
        return workoutRepository.findById(id);
    }
    
    //delete a workout
    public void deleteWorkout(Long id){
        workoutRepository.deleteById(id);

    }


}
