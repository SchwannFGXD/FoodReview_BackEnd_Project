package com.example.food_review.repositories;

import com.example.food_review.model.FoodPlace;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FoodPlaceRepository extends JpaRepository<FoodPlace, Long> {
}
