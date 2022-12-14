package com.example.food_review.controllers;

import com.example.food_review.model.FoodPlace;
import com.example.food_review.model.Review;
import com.example.food_review.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.food_review.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers(){
//        List<User> user = userService.getAllUsers();
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsersAndFilters(
            @RequestParam(required = false, name = "name") String name){
//        Get user by name
        if (name != null){
            return new ResponseEntity<>(userService.findByName(name), HttpStatus.OK);
        }
//        Get all users
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable long id){
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping(value = "/{id}/reviews")
    public ResponseEntity<List<Review>> getAllReviewsFromUserById(@PathVariable long id) {
        Optional <User> user = userService.getUserById(id);
        List<Review> reviews = user.get().getReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/foodplace")
    public ResponseEntity<List<FoodPlace>> getFoodPlacesFromUser(@PathVariable long id) {
        Optional<User> user = userService.getUserById(id);
        List<FoodPlace> foodPlaces = userService.getAllFoodPlacesFromUser(user.get());
        return new ResponseEntity<>(foodPlaces, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<User>  addNewUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteUserById(@PathVariable long id){
        userService.removeUserByID(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        userService.updateUser(user,id);
        return new ResponseEntity<>(user, HttpStatus.OK);


    }
}