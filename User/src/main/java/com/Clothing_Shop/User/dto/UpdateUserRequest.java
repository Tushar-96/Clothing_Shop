package com.Clothing_Shop.User.dto;
 
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    @Size(min = 1)
    private String username;
 
    @Email
    private String email;
 
    private String role;
}