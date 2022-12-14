package com.example.food_review.controllers;

import com.example.food_review.model.FoodPlace;
import com.example.food_review.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.food_review.services.FoodPlaceService;
import com.example.food_review.services.ReviewService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foodplace")
public class FoodPlaceController {

    @Autowired
    FoodPlaceService foodPlaceService;
    @Autowired
    ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<FoodPlace>> getAllFoodPlace(){
        List<FoodPlace> foodPlace = foodPlaceService.getAllFoodPlaces();
        return new ResponseEntity<>(foodPlace, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<FoodPlace> getAllFoodPlaceById(@PathVariable long id){
        Optional <FoodPlace> foodPlace = foodPlaceService.getFoodPlaceById(id);
        if(foodPlace.isPresent()){
            return new ResponseEntity<>(foodPlace.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/{id}/reviews")
    public ResponseEntity<List<Review>> getAllReviewsFromFoodPlaceById(@PathVariable long id) {
        Optional <FoodPlace> foodPlace =foodPlaceService.getFoodPlaceById(id);
        List<Review> reviews = foodPlace.get().getReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FoodPlace>  newFoodPlace(@RequestBody FoodPlace foodPlace){
        foodPlaceService.addFoodPlace(foodPlace);
        return new ResponseEntity<>(foodPlace, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteFoodPlace(@PathVariable long id){
        foodPlaceService.removeFoodPlaceById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<FoodPlace> updateFoodPlace(@RequestBody FoodPlace foodPlace, @PathVariable Long id){
        foodPlaceService.updateFoodPlace(foodPlace,id);
        return new ResponseEntity<>(foodPlace, HttpStatus.OK);


    }
}
