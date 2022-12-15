package com.example.food_review.services;

import com.example.food_review.dtos.ReviewDTO;
import com.example.food_review.model.FoodPlace;
import com.example.food_review.model.Review;
import com.example.food_review.model.User;
import com.example.food_review.repositories.FoodPlaceRepository;
import com.example.food_review.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.food_review.repositories.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    FoodPlaceRepository foodPlaceRepository;
    @Autowired
    UserRepository userRepository;

    public List<Review> displayAllReviews(){
        return reviewRepository.findAll();
    }

    public Optional<Review> findReviewById(Long id){
        return reviewRepository.findById(id);
    }

    public Review addReview(ReviewDTO reviewDTO){
        User userObject = userRepository.findById(reviewDTO.getUserId()).get();
        FoodPlace foodPlaceObject = foodPlaceRepository.findById(reviewDTO.getFoodPlaceId()).get();
        Review review= new Review(reviewDTO.getRating(), reviewDTO.getReviewText(), reviewDTO.getDate(), foodPlaceObject,userObject);
        reviewRepository.save(review);
        return review;
    }

    public void deleteReviewById(Long id){
        reviewRepository.deleteById(id);
    }

    public void updateReview(Review review, Long id){
        Review reviewToUpdate = reviewRepository.findById(id).get();
        reviewToUpdate.setRating(review.getRating());
        reviewToUpdate.setReviewText(review.getReviewText());
        reviewToUpdate.setDate(review.getDate());
        reviewRepository.save(reviewToUpdate);
    }
}
