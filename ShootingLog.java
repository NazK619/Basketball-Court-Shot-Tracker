package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "shooting_logs")
public class ShootingLog {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    
    private String zone;

    private int attempts = 0;
    
    private int makes = 0;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "workout_id")
    Workout workout;

    public ShootingLog(){
        return;
    }
    public ShootingLog(Workout workout, String zone, int attempts, int makes){
        this.workout = workout;
        setZone(zone);
        setAttempts(attempts);
        setMakes(makes);
    }
    public double getShootingPercentage(){
        if (attempts == 0) {
        return 0.0;
    }
    return ((double) makes / attempts) * 100.0;
}


    public void setId(Long id){
        this.id = id;
    }

    public void setMakes(int makes){
        this.makes = makes;
    }

    public void setZone(String zone){
        /*
        mid = mid-range
        z1(underBasket)z2(leftMid)z3(midM)z4(rightMid)
        z5(farLeftcornerMid)z6(farLeftwingMid)z7(farTopMid)z8(farRightwingMid)z9(farRightcornerMid)
        z10(leftCorner)z11(leftWing)z12(topKey)z13(rightWing)z14(rightCorner)
        */
        this.zone = zone;
        //maybe do int instead and have ints correlate to zones as listed above or matchFound
    } 
    public void setAttempts(int attempts){
        this.attempts = attempts;
    } 

    public int getMakes(){
        return makes;
    }

    public int getAttempts(){
        return attempts;
    }

    public Long getId(){
        return id;
    }
    public String getZone(){
      return zone;   
    }
    public Workout getWorkout(){
        return workout;
    }
    

}