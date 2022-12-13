package com.example.food_review.components;

import com.example.food_review.model.FoodPlace;
import com.example.food_review.model.Review;
import com.example.food_review.model.User;
import com.example.food_review.repositories.FoodPlaceRepository;
import com.example.food_review.repositories.ReviewRepository;
import com.example.food_review.repositories.UserRepository;
import com.example.food_review.services.FoodPlaceService;
import com.example.food_review.services.ReviewService;
import com.example.food_review.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    FoodPlaceService foodPlaceService;

    @Autowired
    UserService userService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    FoodPlaceRepository foodPlaceRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    public Dataloader(){
    }

    @Override
    public void run (ApplicationArguments args ) throws Exception{

        FoodPlace skewers_beers = new FoodPlace("Skewers&Beers", "Chinese",
                "12:00 - 22:00", "www.Skewer&Beer.com" );

        FoodPlace chinChinLab = new FoodPlace("Chin Chin Labs", "Desert", "12:30 - 22:00",
                "www.ChinChin.com");

        FoodPlace silkRoad = new FoodPlace("Slik Road", "Chinese",
                "14:00 - 23:30", "www.Slik_Road.com");

        FoodPlace amigos = new FoodPlace("Amigos", "Mexican",
                "11:00 - 20:30", "www.Amigos.com");

        FoodPlace tsujiri = new FoodPlace("Tsujiri", "Japanese",
                "10:00 - 22:00", "www.tsujiri_london.com");

        foodPlaceRepository.saveAll(List.of(skewers_beers, chinChinLab, silkRoad, amigos, tsujiri));

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

        userRepository.saveAll(List.of(Emma, Shawn, Georgia, Salma, Anna, Jenna, Zsolt, Colin, Richard, Ed));


        Review review1 = new Review(3, "The food was decent.", LocalDate.of(2022,10,06));
        Review review2 = new Review(4.5, "The food was amazing.",LocalDate.of(2022,10, 12));
        Review review3 = new Review(1, "The establishment had rats falling from the ceiling.",LocalDate.of(2022,10,30));
        Review review4 = new Review(4, "Lost for words.",LocalDate.of(2022, 11, 01));
        Review review5 = new Review(5, "Stunned.",LocalDate.of(2022,11,06));
        Review review6 = new Review(2, "The noodles looked questionable.",LocalDate.of(2022,11,25));
        Review review7 = new Review(3.5, "Rude staff, I was ignored by the waiter.",LocalDate.of(2022,11,30));
        Review review8 = new Review(5, "The meal was exquisite.",LocalDate.of(2022,12,01));
        Review review9 = new Review(1.5, "My Chicken nugget looked like a cockroach.",LocalDate.of(2022,11,05));
        Review review10 = new Review(4.5, "The food was rich in umami.",LocalDate.of(2022,11,25));

        reviewRepository.saveAll(List.of(review1, review2, review3, review4, review5, review6, review7, review8, review9, review10));
        Emma.addReview(review1);
        Emma.addReview(review8);
        Emma.addReview(review9);

        Shawn.addReview(review2);

        Salma.addReview(review3);
        Salma.addReview(review10);

        Georgia.addReview(review4);

        Zsolt.addReview(review5);

        Anna.addReview(review6);

        Jenna.addReview(review7);

        skewers_beers.addReview(review7);
        skewers_beers.addReview(review1);
        skewers_beers.addReview(review6);
        skewers_beers.addReview(review8);

        chinChinLab.addReview(review2);

        silkRoad.addReview(review4);
        silkRoad.addReview(review5);

        amigos.addReview(review3);
        amigos.addReview(review9);

        tsujiri.addReview(review10);


        foodPlaceService.addFoodPlace(tsujiri);
        foodPlaceRepository.save(tsujiri);
        foodPlaceService.addFoodPlace(amigos);
        foodPlaceRepository.save(amigos);
        foodPlaceService.addFoodPlace(silkRoad);
        foodPlaceRepository.save(silkRoad);
        foodPlaceService.addFoodPlace(chinChinLab);
        foodPlaceRepository.save(chinChinLab);
        foodPlaceService.addFoodPlace(skewers_beers);
        foodPlaceRepository.save(skewers_beers);

        userService.addUser(Emma);
        userRepository.save(Emma);
        userService.addUser(Shawn);
        userRepository.save(Shawn);
        userService.addUser(Georgia);
        userRepository.save(Georgia);
        userService.addUser(Salma);
        userRepository.save(Salma);
        userService.addUser(Anna);
        userRepository.save(Anna);
        userService.addUser(Jenna);
        userRepository.save(Jenna);
        userService.addUser(Zsolt);
        userRepository.save(Zsolt);
        userService.addUser(Colin);
        userRepository.save(Colin);
        userService.addUser(Richard);
        userRepository.save(Richard);
        userService.addUser(Ed);
        userRepository.save(Ed);


        reviewService.addReview(review1);
        reviewRepository.save(review1);
        reviewService.addReview(review2);
        reviewRepository.save(review2);
        reviewService.addReview(review3);
        reviewRepository.save(review3);
        reviewService.addReview(review4);
        reviewRepository.save(review4);
        reviewService.addReview(review5);
        reviewRepository.save(review5);
        reviewService.addReview(review6);
        reviewRepository.save(review6);
        reviewService.addReview(review7);
        reviewRepository.save(review7);
        reviewService.addReview(review8);
        reviewRepository.save(review8);
        reviewService.addReview(review9);
        reviewRepository.save(review9);
        reviewService.addReview(review10);
        reviewRepository.save(review10);


    }



}
