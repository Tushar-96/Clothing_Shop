package com.Clothing_Shop.User.controller;
 
import com.Clothing_Shop.User.domain.User;
import com.Clothing_Shop.User.dto.*;
import com.Clothing_Shop.User.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.net.URI;
 
@RestController
@RequestMapping("/api/users")
public class UserController {
 
    private final UserService userService;
 
    public UserController(UserService userService) { this.userService = userService; }
 
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest req) {
        try {
            User.Role role = null;
            if (req.getRole() != null && !req.getRole().isBlank()) {
                role = User.Role.valueOf(req.getRole().trim().toUpperCase());
            }
 
            User created = userService.register(req.getUsername(), req.getEmail(), req.getPassword(), role);
            UserResponse resp = mapToResponse(created);
            return ResponseEntity.created(URI.create("/api/users/" + created.getId())).body(resp);
 
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
 
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@Valid @RequestBody LoginRequest req) {
        return userService.authenticate(req.getUsernameOrEmail(), req.getPassword())
                .map(u -> ResponseEntity.ok(mapToResponse(u)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        return userService.findById(id)
                .map(u -> ResponseEntity.ok(mapToResponse(u)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
 
    @GetMapping
    public ResponseEntity<UserResponse> getByUsername(@RequestParam(value = "username", required = false) String username) {
        if (username == null || username.isBlank()) return ResponseEntity.badRequest().build();
        return userService.findByUsernameOrEmail(username)
                .map(u -> ResponseEntity.ok(mapToResponse(u)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest req) {
        try {
            User.Role role = null;
            if (req.getRole() != null && !req.getRole().isBlank()) {
                role = User.Role.valueOf(req.getRole().trim().toUpperCase());
            }
            User updated = userService.updateUser(id, req.getUsername(), req.getEmail(), role);
            return ResponseEntity.ok(mapToResponse(updated));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
 
    @PostMapping("/{id}/change-password")
    public ResponseEntity<Void> changePassword(@PathVariable Long id, @Valid @RequestBody ChangePasswordRequest req) {
        try {
            userService.changePassword(id, req.getCurrentPassword(), req.getNewPassword());
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
 
    private UserResponse mapToResponse(User u) {
        return new UserResponse(u.getId(), u.getUsername(), u.getEmail(), u.getRole().name(), u.getCreatedAt(), u.getUpdatedAt());
    }
}
 