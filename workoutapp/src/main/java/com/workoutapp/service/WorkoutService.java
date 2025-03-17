package com.workoutapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workoutapp.entity.Workout;
import com.workoutapp.exception.ResourceNotFoundException;
import com.workoutapp.repository.WorkoutRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class WorkoutService {
    
    @Autowired
    private WorkoutRepository workoutRepository;
    
    public Workout createWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }
    
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }
    
    public Workout getWorkoutById(Long id) {
        return workoutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Workout", "id", id));
    }
    
    public List<Workout> getWorkoutsByCategory(String category) {
        return workoutRepository.findByCategory(category);
    }
    
    public Workout updateWorkout(Long id, Workout workoutDetails) {
        Workout workout = getWorkoutById(id);
        
        workout.setTitle(workoutDetails.getTitle());
        workout.setDuration(workoutDetails.getDuration());
        workout.setCaloriesBurnt(workoutDetails.getCaloriesBurnt());
        workout.setCategory(workoutDetails.getCategory());
        
        return workoutRepository.save(workout);
    }
    
    public void deleteWorkout(Long id) {
        Workout workout = getWorkoutById(id);
        workoutRepository.delete(workout);
    }
}
