package com.workoutapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.workoutapp.dto.WorkoutDto;
import com.workoutapp.entity.Workout;
import com.workoutapp.service.WorkoutService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/workouts")
@Tag(name = "Workout Controller", description = "API for workout management")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @PostMapping
    @Operation(summary = "Create a new workout", description = "Creates a new workout record with the provided details")
    @ApiResponse(responseCode = "201", description = "Workout created successfully")
    public ResponseEntity<WorkoutDto> createWorkout(@Valid @RequestBody WorkoutDto workoutDTO) {
        // Convert DTO to Entity
        Workout workout = modelMapper.map(workoutDTO, Workout.class);
        
        // Save workout
        Workout savedWorkout = workoutService.createWorkout(workout);
        
        // Convert Entity to DTO
        WorkoutDto savedWorkoutDTO = modelMapper.map(savedWorkout, WorkoutDto.class);
        
        return new ResponseEntity<>(savedWorkoutDTO, HttpStatus.CREATED);
    }
    
    @GetMapping
    @Operation(summary = "Get all workouts", description = "Returns all workout records")
    public List<WorkoutDto> getAllWorkouts() {
        List<Workout> workouts = workoutService.getAllWorkouts();
        
        return workouts.stream()
                .map(workout -> modelMapper.map(workout, WorkoutDto.class))
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get workout by ID", description = "Returns a workout record for the specified ID")
    @ApiResponse(responseCode = "200", description = "Workout found")
    @ApiResponse(responseCode = "404", description = "Workout not found")
    public ResponseEntity<WorkoutDto> getWorkoutById(@PathVariable Long id) {
        Workout workout = workoutService.getWorkoutById(id);
        
        // Convert Entity to DTO
        WorkoutDto workoutDTO = modelMapper.map(workout, WorkoutDto.class);
        
        return ResponseEntity.ok(workoutDTO);
    }
    
    @GetMapping("/category/{category}")
    @Operation(summary = "Get workouts by category", description = "Returns all workout records for the specified category")
    public List<WorkoutDto> getWorkoutsByCategory(@PathVariable String category) {
        List<Workout> workouts = workoutService.getWorkoutsByCategory(category);
        
        return workouts.stream()
                .map(workout -> modelMapper.map(workout, WorkoutDto.class))
                .collect(Collectors.toList());
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update a workout", description = "Updates a workout record for the specified ID")
    @ApiResponse(responseCode = "200", description = "Workout updated successfully")
    @ApiResponse(responseCode = "404", description = "Workout not found")
    public ResponseEntity<WorkoutDto> updateWorkout(@PathVariable Long id, @Valid @RequestBody WorkoutDto workoutDTO) {
        // Convert DTO to Entity
        Workout workoutRequest = modelMapper.map(workoutDTO, Workout.class);
        
        // Update workout
        Workout updatedWorkout = workoutService.updateWorkout(id, workoutRequest);
        
        // Convert Entity to DTO
        WorkoutDto updatedWorkoutDTO = modelMapper.map(updatedWorkout, WorkoutDto.class);
        
        return ResponseEntity.ok(updatedWorkoutDTO);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a workout", description = "Deletes a workout record for the specified ID")
    @ApiResponse(responseCode = "204", description = "Workout deleted successfully")
    @ApiResponse(responseCode = "404", description = "Workout not found")
    public ResponseEntity<Void> deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
