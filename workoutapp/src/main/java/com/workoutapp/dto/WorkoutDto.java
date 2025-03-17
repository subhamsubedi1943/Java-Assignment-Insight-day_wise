package com.workoutapp.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class WorkoutDto {
    
    private Long id;
    
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private String title;
    
    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be at least 1 minute")
    private Integer duration;
    
    @NotNull(message = "Calories burnt is required")
    @Min(value = 0, message = "Calories burnt must be non-negative")
    private Integer caloriesBurnt;
    
    @NotBlank(message = "Category is required")
    private String category;
    
    public WorkoutDto() {}
    
    public WorkoutDto(Long id, String title, Integer duration, Integer caloriesBurnt, String category) {
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
        return "WorkoutDTO [id=" + id + ", title=" + title + ", duration=" + duration + ", caloriesBurnt=" + caloriesBurnt
                + ", category=" + category + "]";
    }
}
