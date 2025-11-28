package com.Clothing_Shop.User.service;
 
import com.Clothing_Shop.User.domain.User;
import com.Clothing_Shop.User.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import java.util.Optional;
 
@Service
public class UserService {
 
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
 
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
 
    @Transactional
    public User register(String username, String email, String password, User.Role role) {
        if (username == null || username.isBlank()) throw new IllegalArgumentException("username required");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("email required");
        if (password == null || password.length() < 8) throw new IllegalArgumentException("password must be at least 8 chars");
 
        if (userRepository.existsByUsername(username)) throw new IllegalStateException("username taken");
        if (userRepository.existsByEmail(email)) throw new IllegalStateException("email registered");
 
        User.Role finalRole = (role == null) ? User.Role.CUSTOMER : role;
 
        User user = User.builder()
                .username(username.trim())
                .email(email.trim())
                .password(passwordEncoder.encode(password))
                .role(finalRole)
                .build();
 
        return userRepository.save(user);
    }
 
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
 
    @Transactional(readOnly = true)
    public Optional<User> findByUsernameOrEmail(String usernameOrEmail) {
        return userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
    }
 
    @Transactional(readOnly = true)
    public Optional<User> authenticate(String usernameOrEmail, String rawPassword) {
        return findByUsernameOrEmail(usernameOrEmail)
                .filter(user -> passwordEncoder.matches(rawPassword, user.getPassword()));
    }
 
    @Transactional
    public User updateUser(Long userId, String newUsername, String newEmail, User.Role newRole) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("user not found"));
 
        if (newUsername != null && !newUsername.isBlank() && !newUsername.equals(user.getUsername())) {
            if (userRepository.existsByUsername(newUsername)) throw new IllegalStateException("username taken");
            user.setUsername(newUsername.trim());
        }
 
        if (newEmail != null && !newEmail.isBlank() && !newEmail.equals(user.getEmail())) {
            if (userRepository.existsByEmail(newEmail)) throw new IllegalStateException("email registered");
            user.setEmail(newEmail.trim());
        }
 
        if (newRole != null) user.setRole(newRole);
 
        return userRepository.save(user);
    }
 
    @Transactional
    public void changePassword(Long userId, String currentPassword, String newPassword) {
        if (newPassword == null || newPassword.length() < 8) throw new IllegalArgumentException("new password must be at least 8 chars");
 
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("user not found"));
 
        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            throw new IllegalArgumentException("current password incorrect");
        }
 
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
 
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
 