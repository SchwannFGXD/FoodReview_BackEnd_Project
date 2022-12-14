package com.example.food_review.services;


import com.example.food_review.model.FoodPlace;
import com.example.food_review.model.Review;
import com.example.food_review.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.food_review.repositories.UserRepository;

import java.util.ArrayList;
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

    public void addReview(Review review, User user){
        user.getReviews().add(review);
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

    public List<FoodPlace> getAllFoodPlacesFromUser (User user){
        List<Review> foodPlaceReviews = user.getReviews();
        List<FoodPlace> foodPlaceList = new ArrayList<>();
        for (Review review : foodPlaceReviews){
            foodPlaceList.add(review.getFoodPlace());
        }
        return foodPlaceList;
    }

    public List<User> findByName (String name){
        return userRepository.findByNameEquals(name);
    }
}
