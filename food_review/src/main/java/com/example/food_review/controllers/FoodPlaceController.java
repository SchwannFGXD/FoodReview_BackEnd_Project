package com.example.food_review.controllers;

import com.example.food_review.model.FoodPlace;
import com.example.food_review.model.Review;
import com.example.food_review.model.User;
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

    //get all foodplaces
    @GetMapping
    public ResponseEntity<List<FoodPlace>> getAllFoodPlace(){
        List<FoodPlace> foodPlace = foodPlaceService.getAllFoodPlaces();
        return new ResponseEntity<>(foodPlace, HttpStatus.OK);
    }

    @GetMapping(value = "/name")
    public ResponseEntity<List<FoodPlace>> getAllFoodPlacesAndFilters(
            @RequestParam(required = false, name = "name") String name
    ){
      if (name != null){
          return new ResponseEntity<>(foodPlaceService.findByName(name), HttpStatus.OK);
      }
         return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }


    @GetMapping(value = "/foodtype")
    public ResponseEntity<List<FoodPlace>> findFoodPlaceByFoodType(
            @RequestParam(required = false, name = "foodType") String foodType
    ) {
        if (foodType != null) {
            return new ResponseEntity<>(foodPlaceService.findByFoodType(foodType), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    //get random foodplace
    @GetMapping("/random")
    public ResponseEntity<FoodPlace> getRandomFoodPlace(){
        Optional <FoodPlace> foodPlace = foodPlaceService.getRandomFoodPlace();
        if(foodPlace.isPresent()){
            return new ResponseEntity<>(foodPlace.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //get food place by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<FoodPlace> getFoodPlaceById(@PathVariable long id) {
        Optional<FoodPlace> foodPlace = foodPlaceService.getFoodPlaceById(id);
        if (foodPlace.isPresent()) {
            return new ResponseEntity<>(foodPlace.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    //get reviews from a foodplace
    @GetMapping(value = "/{id}/reviews")
    public ResponseEntity<List<Review>> getAllReviewsFromFoodPlaceById(@PathVariable long id) {
        Optional<FoodPlace> foodPlace = foodPlaceService.getFoodPlaceById(id);
        List<Review> reviews = foodPlace.get().getReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    //add food place
    @PostMapping
    public ResponseEntity<FoodPlace> newFoodPlace(@RequestBody FoodPlace foodPlace) {
        foodPlaceService.addFoodPlace(foodPlace);
        return new ResponseEntity<>(foodPlace, HttpStatus.CREATED);
    }

    //delete food place
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteFoodPlace(@PathVariable long id) {
        foodPlaceService.removeFoodPlaceById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    //update food place
    @PutMapping(value = "/{id}")
    public ResponseEntity<FoodPlace> updateFoodPlace(@RequestBody FoodPlace foodPlace, @PathVariable Long id) {
        foodPlaceService.updateFoodPlace(foodPlace, id);
        Optional<FoodPlace>updatedFoodPlace = foodPlaceService.getFoodPlaceById(id);

        return new ResponseEntity<>(updatedFoodPlace.get(), HttpStatus.OK);
    }

    //get average rating
    @GetMapping("/{id}/average_rating")
    public ResponseEntity<Double> getAvg(@PathVariable Long id) {
        Optional<FoodPlace> foodPlace = foodPlaceService.getFoodPlaceById(id);
        if (foodPlace.isPresent()) {
            return new ResponseEntity<>(foodPlaceService.getAvg(foodPlace.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
