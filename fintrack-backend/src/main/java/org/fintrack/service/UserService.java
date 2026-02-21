package org.fintrack.service;

import org.fintrack.entity.User;
import org.fintrack.exception.ResourceNotFoundException;
import org.fintrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUserById(Long id){
        return userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(
                        "User not found with if: " + id
                ));
    }

    public User createUser(User newUser){
        return userRepository.save(newUser);
    }
    public User updateUserDetails(Long id, User updatedDetails) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(updatedDetails.getUsername());

            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

    }
    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found " + id)
        );
        userRepository.delete(user);
    }

}
