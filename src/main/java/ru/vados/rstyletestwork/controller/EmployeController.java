package ru.vados.rstyletestwork.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.vados.rstyletestwork.config.UserPrincipal;
import ru.vados.rstyletestwork.dto.EmployeDto;
import ru.vados.rstyletestwork.service.EmployeService;

@RestController
@RequestMapping("/api/employe")
@AllArgsConstructor
public class EmployeController {

    private final EmployeService employeService;

    @PostMapping("/{employeId}")
    @SecurityRequirement(name = "Bearer Authentication")
    public EmployeDto getByIdEmploye(
            Authentication authentication,
            @PathVariable Long employeId
    ) {
        String senderUsername = authentication.getName();
        return employeService.getEmployeById(employeId);
    }

    @PutMapping
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<String> createPost(@RequestBody EmployeDto employeDto, Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You are not authorized to create a post.");
        }
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        employeService.createEmploye(employeDto);
        return ResponseEntity.ok("Employe created successfully.");
    }
}
