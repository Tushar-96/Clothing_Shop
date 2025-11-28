package com.Clothing_Shop.User.dto;
 
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequest {
    @NotBlank
    private String currentPassword;
 
    @NotBlank
    @Size(min = 8)
    private String newPassword;
}
 