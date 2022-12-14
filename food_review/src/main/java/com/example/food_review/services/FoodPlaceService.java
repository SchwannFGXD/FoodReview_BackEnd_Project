package com.example.food_review.services;
import com.example.food_review.model.FoodPlace;
import com.sun.source.tree.WhileLoopTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.food_review.repositories.FoodPlaceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static java.lang.Long.valueOf;

@Service
public class FoodPlaceService {

    Random rand = new Random();

    @Autowired
    FoodPlaceRepository foodPlaceRepository;

    public List<FoodPlace> getAllFoodPlaces() {return foodPlaceRepository.findAll();}

    public Optional<FoodPlace> getFoodPlaceById(Long id) { return foodPlaceRepository.findById(id);}

    public void addFoodPlace(FoodPlace foodplace) {
        foodPlaceRepository.save(foodplace);
    }

    public void removeFoodPlaceById(Long id) {
//        findallreviews for the foodplace, loop through all food reviews and delete one by one.
        foodPlaceRepository.deleteById(id);}

    public void updateFoodPlace(FoodPlace foodPlace, Long id){
        FoodPlace foodPlaceToUpdate = foodPlaceRepository.findById(id).get();
        foodPlaceToUpdate.setName(foodPlace.getName());
        foodPlaceToUpdate.setFoodType(foodPlace.getFoodType());
        foodPlaceToUpdate.setOpeningHours(foodPlace.getOpeningHours());
        foodPlaceToUpdate.setWebsite(foodPlace.getWebsite());
        foodPlaceRepository.save(foodPlaceToUpdate);
    }

    public Optional<FoodPlace> getRandomFoodPlace() {
        List<FoodPlace> allFoodPlaces = foodPlaceRepository.findAll();
        List<Long> allIds = new ArrayList<>();
        for(FoodPlace foodPlace: allFoodPlaces){
            allIds.add(foodPlace.getId());
        }
        while(true){
            int randomID = rand.nextInt(0,allIds.size());
            Optional <FoodPlace> randomFoodPlace = foodPlaceRepository.findById(allIds.get(randomID));
            if(randomFoodPlace.isPresent()){
                return randomFoodPlace;
            } else {
            }
        }
    }


}
