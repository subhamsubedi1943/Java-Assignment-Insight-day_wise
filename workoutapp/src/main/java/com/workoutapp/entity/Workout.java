package com.workoutapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "workouts")
public class Workout {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    private Long id;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "duration", nullable = false)
    private Integer duration;
    
    @Column(name = "calories_burnt", nullable = false)
    private Integer caloriesBurnt;
    
    @Column(name = "category", nullable = false)
    private String category;
    
    public Workout() {}
    
    public Workout(Long id, String title, Integer duration, Integer caloriesBurnt, String category) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.caloriesBurnt = caloriesBurnt;
        this.category = category;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Integer getDuration() {
        return duration;
    }
    
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    
    public Integer getCaloriesBurnt() {
        return caloriesBurnt;
    }
    
    public void setCaloriesBurnt(Integer caloriesBurnt) {
        this.caloriesBurnt = caloriesBurnt;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    @Override
    public String toString() {
        return "Workout [id=" + id + ", title=" + title + ", duration=" + duration + ", caloriesBurnt=" + caloriesBurnt
                + ", category=" + category + "]";
    }
}


