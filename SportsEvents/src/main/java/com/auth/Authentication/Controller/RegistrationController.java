package com.auth.Authentication.Controller;


import com.auth.Authentication.Services.RegistrationService;
import com.auth.Authentication.dto.RegistrationDTO;
import com.auth.Authentication.entity.Registration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // GET: Fetch all registrations
    @GetMapping("/all")
    public ResponseEntity<?> getAllRegistrations() {
        try {
            List<Registration> registrations = registrationService.getAllRegistrations();
            return ResponseEntity.ok(registrations);
        } catch (RuntimeException e) {
            // Return more specific error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No events available currently");
        }
    }

    // POST: Request a new registration
    @PostMapping("/create")
    public ResponseEntity<?> createRegistration (@RequestParam("registrationDTO") String registrationDTO){

        // Convert JSON string to RegistrationDTO
        ObjectMapper objectMapper = new ObjectMapper();
        RegistrationDTO registrationDTOObject;
        try {
            registrationDTOObject = objectMapper.readValue(registrationDTO, RegistrationDTO.class);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error parsing registrationDTO: " + e.getMessage());
        }

        // Pass the DTO and image bytes to the service for updating the profile
        registrationService.createRegistration(registrationDTOObject);

        return ResponseEntity.ok("Registration request Successful!");
        }


    // PUT: Update registration status
    @PutMapping("/update")
    public ResponseEntity<?> updateRegistration(@RequestParam Long id, @RequestParam String status) {

        // Pass the DTO to the service for updating the registrations
        registrationService.updateRegistration(id, status);

        return ResponseEntity.ok("Event update successful");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRegistration(@PathVariable Long id){
        try {
            registrationService.deleteRegistration(id);
            return ResponseEntity.ok("Registration cancelled successfully");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No request to delete");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> getRegistration(
            @RequestParam(required = false) Long eventId,
            @RequestParam(required = false) Long athleteId) {

        if (eventId != null && athleteId != null) {
            // Search by both eventId and athleteId
            Optional<Registration> registration = registrationService.findByEventIdAndAthleteId(eventId, athleteId);
            return registration.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } else if (eventId != null) {
            // Search by eventId only
            List<Registration> registrations = registrationService.findByEventId(eventId);
            return ResponseEntity.ok(registrations);
        } else if (athleteId != null) {
            // Search by athleteId only
            List<Registration> registrations = registrationService.findByAthleteId(athleteId);
            return ResponseEntity.ok(registrations);
        } else {
            return ResponseEntity.badRequest().body("Either eventId or athleteId must be provided.");
        }
    }
}


