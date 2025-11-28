package com.Clothing_Shop.User.dto;
 
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "username is required")
    private String username;
 
    @NotBlank(message = "email is required")
    @Email(message = "email must be valid")
    private String email;
 
    @NotBlank(message = "password is required")
    @Size(min = 8, message = "password must be at least 8 characters")
    private String password;
 
    private String role;
}
 