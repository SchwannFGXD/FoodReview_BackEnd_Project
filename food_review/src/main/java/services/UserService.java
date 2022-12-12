package services;


import model.FoodPlace;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void removeUserByID(Long id){
        userRepository.deleteById(id);
    }

    public void updateUser(User user, Long id){
        User  userToUpdate = userRepository.findById(id).get();
        userToUpdate.setName(user.getName());
        userRepository.save(userToUpdate);
    }

}
