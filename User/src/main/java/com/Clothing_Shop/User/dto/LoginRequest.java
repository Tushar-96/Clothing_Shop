package com.Clothing_Shop.User.dto;
 
import jakarta.validation.constraints.NotBlank;
import lombok.*;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank
    private String usernameOrEmail;
 
    @NotBlank
    private String password;
}
 