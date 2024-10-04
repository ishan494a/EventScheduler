package com.ishan494a.eventschedulerapp.Service;

import com.ishan494a.eventschedulerapp.Entity.User;
import com.ishan494a.eventschedulerapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User saveUser(String username){
        User user = new User();
        user.setUsername(username);
        return userRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        if (user.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    user.get().getUsername(),
                    "",
                    new ArrayList<>()
            );
        }
        return null;
    }
}
