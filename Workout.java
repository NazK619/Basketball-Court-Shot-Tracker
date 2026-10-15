package com.example.demo.model;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; 
    private LocalDate date;   
    private String notes = " ";

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List<ShootingLog> shootingLogs;

    public Workout(){


    }
    public Workout(LocalDate date, String notes){
        this.date = date; 
        this.notes = notes;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }
    public void setShootingLogs(List<ShootingLog> shootingLog){
        this.shootingLogs = shootingLog;
    }
    public Long getId(){
        return id;
    }
    public LocalDate getDate(){
        return date; 
    }
    public String getNotes(){
        return notes;
    }
    public List<ShootingLog> getShootingLogs(){
        return shootingLogs;
    }
}