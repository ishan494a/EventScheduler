package com.ishan494a.eventschedulerapp.Service;

import com.ishan494a.eventschedulerapp.Entity.UserAccount;
import com.ishan494a.eventschedulerapp.Repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;
    public boolean userExists(String email) {
        return userAccountRepository.findByEmail(email).isPresent();
    }
    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Create BCryptPasswordEncoder instance
    }
    public Optional<UserAccount> findUserByEmail(String email) {
        return userAccountRepository.findByEmail(email); // Return Optional
    }
    public boolean validatePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword); // Compare raw password with hashed password
    }
    public void registerUser(String email, String rawPassword) {
        // Hash the raw password
        String hashedPassword = passwordEncoder.encode(rawPassword);

        // Create a new UserAccount object
        UserAccount newUserAccount = new UserAccount();
        newUserAccount.setEmail(email);
        newUserAccount.setPassword(hashedPassword);

        // Save the user with the hashed password to the database
        userAccountRepository.save(newUserAccount);
    }
}
