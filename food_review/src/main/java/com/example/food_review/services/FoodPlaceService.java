package com.example.food_review.services;
import com.example.food_review.model.FoodPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.food_review.repositories.FoodPlaceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoodPlaceService {
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
        foodPlaceToUpdate.setOpeningHour(foodPlace.getOpeningHour());
        foodPlaceToUpdate.setWebsite(foodPlace.getWebsite());
        foodPlaceRepository.save(foodPlaceToUpdate);
    }


}
