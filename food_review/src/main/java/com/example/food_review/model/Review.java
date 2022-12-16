package com.example.food_review.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;


@Entity(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="rating")
    private double rating;

    @Column(name ="review_text")
    private String reviewText;

    @Column(name ="date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"reviews"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "food_place_id")
    @JsonIgnoreProperties({"reviews","foodPlace"})
    private FoodPlace foodPlace;

    public Review(double rating, String reviewText, LocalDate date,
                  FoodPlace foodPlace, User user){
        this.rating = rating;
        this.reviewText = reviewText;
        this.date = date;
        this.foodPlace = foodPlace;
        this.user = user;
    }

    public Review(){
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public FoodPlace getFoodPlace() {
        return foodPlace;
    }

    public void setFoodPlace(FoodPlace foodPlace) {
        this.foodPlace = foodPlace;
    }

//    public String getFoodPlaceName(){
//        return foodPlace.getName();
//    }
//
//    public String getUserName(){
//        return user.getName();
//    }
}
