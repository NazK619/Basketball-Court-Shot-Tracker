package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.ShootingLog;
import com.example.demo.model.Workout;
import com.example.demo.service.WorkoutService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean 
	public CommandLineRunner demo(WorkoutService workoutService){
		return (args)-> {
		//create a workout sesh
		Workout workout = new Workout();
		workout.setDate(LocalDate.now());
		workout.setNotes("Morning Shooting sesh- feeling good");

		//Create shooting logs for specific zones
		ShootingLog log1 = new ShootingLog(workout, "Left Corner", 20, 14);
		ShootingLog log2 = new ShootingLog(workout, "Top Key", 25, 18);

		//attach the logs to the workout
		List<ShootingLog> logs = new ArrayList<>();
		logs.add(log1);
		logs.add(log2);
		workout.setShootingLogs(logs);

		// save the database using the service
		workoutService.saveWorkout(workout);

		//retrieve all workouts from database and print
		System.out.println("== SAVED WORKOUTS IN SQLITE ==");
		for(Workout w : workoutService.getAllWorkouts()){
			System.out.println("Workout ID: " + w.getId() + " | Date: " + w.getDate() + " | Notes: " + w.getNotes());
			for(ShootingLog sl : w.getShootingLogs()){
					System.out.println("   --> Zone: " + sl.getZone() + " | Makes/Attempts: " + sl.getMakes() + "/" + sl.getAttempts() + " | Percentage: " + sl.getShootingPercentage() + "%");
			}
		}
		System.out.println("====================");
	};
	}
}