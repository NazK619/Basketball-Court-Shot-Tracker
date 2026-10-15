package com.example.demo.controller;

import com.example.demo.model.Workout;
import com.example.demo.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workouts")
@CrossOrigin(origins = "*") //allows frontend to comm w this back easily
public class WorkoutController {

    @Autowired 
    private WorkoutService workoutService;

    //POST save a nnew workout sesh w the zone shooting logs
    @PostMapping
    public Workout createWorkout(@RequestBody Workout workout){
        return workoutService.saveWorkout(workout);
    }

    //GET retrieve all past workout histories to calc stats / display heatmap
    @GetMapping
    public List<Workout> getAllWorkouts(){
        return workoutService.getAllWorkouts();
    }

    //GET retrieve a single workout by its ID
    @GetMapping("/{id")
    public Optional<Workout> getWorkoutById(@PathVariable Long id){
        return workoutService.getWorkoutById(id);
    }

    //DELETE  delete a sesh

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable Long id){
        workoutService.deleteWorkout(id);
    }
}