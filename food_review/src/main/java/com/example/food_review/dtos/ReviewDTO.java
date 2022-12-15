package com.example.food_review.dtos;

import java.time.LocalDate;

public class ReviewDTO {

    private double rating;
    private String reviewText;
    private LocalDate date;

    private Long userId;

    private Long foodPlaceId;

    public ReviewDTO(double rating, String reviewText, LocalDate date, Long userId, Long foodPlaceId){
        this.rating=rating;
        this.reviewText=reviewText;
        this.date=date;
        this.userId=userId;
        this.foodPlaceId=foodPlaceId;
    }

    public ReviewDTO(){
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFoodPlaceId() {
        return foodPlaceId;
    }

    public void setFoodPlaceId(Long foodPlaceId) {
        this.foodPlaceId = foodPlaceId;
    }
}
