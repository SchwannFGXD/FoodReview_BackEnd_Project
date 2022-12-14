package com.example.food_review.repositories;

import com.example.food_review.model.FoodPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodPlaceRepository extends JpaRepository<FoodPlace, Long> {

    List<FoodPlace> findByName(String name);

    List<FoodPlace> findByFoodType(String foodType);

}
