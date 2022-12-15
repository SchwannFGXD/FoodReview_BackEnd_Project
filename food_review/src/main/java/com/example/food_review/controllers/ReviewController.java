package com.example.food_review.controllers;

import com.example.food_review.dtos.ReviewDTO;
import com.example.food_review.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.food_review.services.ReviewService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    //gets all reviews
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.displayAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    //gets review by its id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable long id) {
        Optional<Review> review = reviewService.findReviewById(id);
        if (review.isPresent()) {
            return new ResponseEntity<>(review.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    //adds a review
    @PostMapping
    public ResponseEntity<Review> addNewReview(@RequestBody ReviewDTO reviewDTO) {
        Review review = reviewService.addReview(reviewDTO);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    //deletes a review
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteReviewById(@PathVariable long id) {
        reviewService.deleteReviewById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    //updates a review
    @PutMapping(value = "/{id}")
    public ResponseEntity<Review> updateReview(@RequestBody ReviewDTO reviewDTO, @PathVariable Long id) {
        Review review = reviewService.updateReview(reviewDTO, id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }
}