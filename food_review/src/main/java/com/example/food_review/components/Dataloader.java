package com.example.food_review.components;

import com.example.food_review.model.FoodPlace;
import com.example.food_review.model.Review;
import com.example.food_review.model.User;
import com.example.food_review.services.FoodPlaceService;
import com.example.food_review.services.ReviewService;
import com.example.food_review.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

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

        User Emma = new User("Emma");
        User Shawn = new User("Shawn");
        User Georgia = new User("Georgia");
        User Salma = new User("Salma");
        User Anna = new User("Anna");
        User Jenna = new User("Jenna");
        User Zsolt = new User("Zsolt");
        User Colin = new User("Colin");
        User Richard = new User("Richard");
        User Ed = new User("Ed");


        Review review1 = new Review(3, "The food was decent.", LocalDate.of(2022,10,06));
        Review review2 = new Review(4.5, "The food was amazing.",LocalDate.of(2022,10, 12));
        Review review3 = new Review(1, "The establishment had rats falling from the ceiling.",LocalDate.of(2022,10,30));
        Review review4 = new Review(4, "Lost for words.",LocalDate.of(2022, 11, 01));
        Review review5 = new Review(5, "Stunned.",LocalDate.of(2022,11,06));
        Review review6 = new Review(2, "The spaghetti looked questionable.",LocalDate.of(2022,11,25));
        Review review7 = new Review(3.5, "Rude staff, I was ignored by the waiter.",LocalDate.of(2022,11,30));
        Review review8 = new Review(5, "The meal was exquisite.",LocalDate.of(2022,12,01));
        Review review9 = new Review(1.5, "My Chicken nugget looked like a cockroach.",LocalDate.of(2022,11,05));
        Review review10 = new Review(4.5, "The food was rich in umami.",LocalDate.of(2022,11,25));



         

    }



}
