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
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;
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
                LocalTime.of(9,00), LocalTime.of(16,00), "www.Skewer&Beer.com" );

        FoodPlace chinChinLab = new FoodPlace("Chin Chin Labs", "Desert", LocalTime.of(15,00),LocalTime.of(21,00),
                "www.ChinChin.com");

        FoodPlace silkRoad = new FoodPlace("Silk Road", "Chinese",
                LocalTime.of(12,00), LocalTime.of(23,00), "www.Slik_Road.com");

        FoodPlace amigos = new FoodPlace("Amigos", "Mexican",
                LocalTime.of(13,00),LocalTime.of(21,00), "www.Amigos.com");

        FoodPlace tsujiri = new FoodPlace("Tsujiri", "Japanese",
                LocalTime.of(12,00),LocalTime.of(22,00), "www.tsujiri_london.com");

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

//
        Review review1 = new Review(3, "The food was decent.", LocalDate.of(2022,10,06), skewers_beers, Emma);
        Review review2 = new Review(4.5, "The food was amazing.",LocalDate.of(2022,10, 12), chinChinLab, Shawn);
        Review review3 = new Review(1, "The establishment had rats falling from the ceiling.",LocalDate.of(2022,10,30),amigos, Salma);
        Review review4 = new Review(4, "Lost for words.",LocalDate.of(2022, 11, 01), silkRoad, Georgia);
        Review review5 = new Review(5, "Stunned.",LocalDate.of(2022,11,06), silkRoad, Zsolt);
        Review review6 = new Review(2, "The noodles looked questionable.",LocalDate.of(2022,11,25),skewers_beers, Anna);
        Review review7 = new Review(3.5, "Rude staff, I was ignored by the waiter.",LocalDate.of(2022,11,30), skewers_beers, Jenna);
        Review review8 = new Review(5, "The meal was exquisite.",LocalDate.of(2022,12,01), skewers_beers, Emma);
        Review review9 = new Review(1.5, "My chicken nugget looked like a cockroach.",LocalDate.of(2022,11,05), amigos, Emma);
        Review review10 = new Review(4.5, "The food was rich in umami.",LocalDate.of(2022,11,25), tsujiri, Salma);

        reviewRepository.save(review1);
        reviewRepository.save(review2);
        reviewRepository.save(review3);
        reviewRepository.save(review4);
        reviewRepository.save(review5);
        reviewRepository.save(review6);
        reviewRepository.save(review7);
        reviewRepository.save(review8);
        reviewRepository.save(review9);
        reviewRepository.save(review10);

        List<FoodPlace> allFoodPlaces = foodPlaceRepository.findAll();
        for (FoodPlace foodPlaceToUpdate: allFoodPlaces){
            foodPlaceToUpdate.update();
            foodPlaceRepository.save(foodPlaceToUpdate);
        }
    }
}
