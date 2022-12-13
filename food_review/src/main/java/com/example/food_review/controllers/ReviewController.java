package com.example.food_review.controllers;

import com.example.food_review.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.food_review.services.ReviewService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.displayAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable long id) {
        Optional<Review> review = reviewService.findReviewById(id);
        if (review.isPresent()) {
            return new ResponseEntity<>(review.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<Review> addNewReview(@RequestBody Review review) {
        reviewService.addReview(review);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteReviewById(@PathVariable long id) {
        reviewService.deleteReviewById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Review> updateReview(@RequestBody Review review, @PathVariable Long id) {
        reviewService.updateReview(review, id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }
}