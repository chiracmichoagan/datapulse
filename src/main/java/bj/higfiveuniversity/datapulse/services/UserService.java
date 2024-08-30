package bj.higfiveuniversity.datapulse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import bj.higfiveuniversity.datapulse.model.User;
import bj.higfiveuniversity.datapulse.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

     public List<User> getAllUsers() {
        return userRepository.findAll();

    }

     public User getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User non trouvé"));

        return user;
    }

     public User createdUser(User user) {
        User newUser = userRepository.save(user);
        return newUser;
    }
    
    public User updatedUser(Long id,  User user) {
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User avec l'id " + id + "non trouvé"));

        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());

        return userToUpdate;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}