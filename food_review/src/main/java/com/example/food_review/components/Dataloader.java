package com.example.food_review.components;

import com.example.food_review.model.FoodPlace;
import com.example.food_review.services.FoodPlaceService;
import com.example.food_review.services.ReviewService;
import com.example.food_review.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    FoodPlaceService foodPlaceService;

    @Autowired
    UserService userService;

    @Autowired
    ReviewService reviewService;

    public Dataloader(){
    }

    @Override
    public void run (ApplicationArguments args ) throws Exception{

        FoodPlace skewers_beers = new FoodPlace("Skewers&Beers", "Chinese",
                "12:00 - 22:00", "www.Skewer&Beer.com" );

        FoodPlace chinChinLab = new FoodPlace("Chin Chin Labs", "Hot Drinks", "12:30 - 22:00",
                "www.ChinChin.com");

        FoodPlace silkRoad = new FoodPlace("Slik Road", "Chinese",
                "14:00 - 23:30", "www.Slik_Road.com");

        FoodPlace amigos = new FoodPlace("Amigos", "Mexican",
                "11:00 - 20:30", "www.Amigos.com");

        FoodPlace tsujiri = new FoodPlace("Tsujiri", "Japanese",
                "10:00 - 22:00", "www.tsujiri_london.com");
    }

}
