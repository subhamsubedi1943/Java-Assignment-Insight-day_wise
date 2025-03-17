package com.workoutapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.workoutapp.dto.WorkoutDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/client")
@Tag(name = "Workout Client Controller", description = "Client API for consuming workout services")
public class WorkoutClientController {

    private static final String WORKOUT_API_BASE_URL = "http://localhost:8083/api/workouts";
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping
    @Operation(summary = "Get all workouts", description = "Consumes the workout API to get all workouts")
    public List<WorkoutDto> getAllWorkouts() {
        ResponseEntity<WorkoutDto[]> response = restTemplate.getForEntity(WORKOUT_API_BASE_URL, WorkoutDto[].class);
        return Arrays.asList(response.getBody());
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get workout by ID", description = "Consumes the workout API to get a workout by ID")
    public WorkoutDto getWorkoutById(@PathVariable Long id) {
        return restTemplate.getForObject(WORKOUT_API_BASE_URL + "/" + id, WorkoutDto.class);
    }
    
    @GetMapping("/category/{category}")
    @Operation(summary = "Get workouts by category", description = "Consumes the workout API to get workouts by category")
    public List<WorkoutDto> getWorkoutsByCategory(@PathVariable String category) {
        ResponseEntity<WorkoutDto[]> response = restTemplate.getForEntity(
                WORKOUT_API_BASE_URL + "/category/" + category, WorkoutDto[].class);
        return Arrays.asList(response.getBody());
    }
    
    @PostMapping
    @Operation(summary = "Create a new workout", description = "Consumes the workout API to create a new workout")
    public WorkoutDto createWorkout(@RequestBody WorkoutDto workoutDTO) {
        return restTemplate.postForObject(WORKOUT_API_BASE_URL, workoutDTO, WorkoutDto.class);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update a workout", description = "Consumes the workout API to update a workout")
    public void updateWorkout(@PathVariable Long id, @RequestBody WorkoutDto workoutDTO) {
        restTemplate.put(WORKOUT_API_BASE_URL + "/" + id, workoutDTO);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a workout", description = "Consumes the workout API to delete a workout")
    public void deleteWorkout(@PathVariable Long id) {
        restTemplate.delete(WORKOUT_API_BASE_URL + "/" + id);
    }
}
