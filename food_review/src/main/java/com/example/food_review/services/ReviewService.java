package com.example.food_review.services;

import com.example.food_review.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.food_review.repositories.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public List<Review> displayAllReviews(){
        return reviewRepository.findAll();
    }

    public Optional<Review> findReviewById(Long id){
        return reviewRepository.findById(id);
    }

    public void addReview(Review review){
        reviewRepository.save(review);
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
