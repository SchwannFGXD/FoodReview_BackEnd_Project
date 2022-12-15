package com.example.food_review.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "food_places")
public class FoodPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "food_type")
    private String foodType;
    @Column(name = "opening_hour")
    private LocalTime openingHour;
    @Column(name = "closing_hour")
    private LocalTime closingHour;
    @Column(name = "website")
    private String website;
    @Column (name = "average_rating")
    private double averageRating;

    @OneToMany (mappedBy = "foodPlace")
    @JsonIgnoreProperties({"reviews","foodPlace"})
    private List<Review> reviews;

    public FoodPlace() {
    }

    public FoodPlace(String name, String foodType, LocalTime openingHour,LocalTime closingHour, String website) {
        this.name = name;
        this.foodType = foodType;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.website = website;
        this.reviews = new ArrayList<>();
        this.averageRating = 0;
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public LocalTime getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(LocalTime openingHours) {
        this.openingHour = openingHour;
    }

    public LocalTime getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


    public double getAverageRating() {
//        double sum=0;
//        if(reviews.isEmpty()){
//            averageRating =0;
            return averageRating;
//        }
//        for ( Review review: reviews) {
//            double number = review.getRating();
//            sum += number;
//        }
//        averageRating= (sum/reviews.size());
//        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void update(){
        double sum=0;
        if(reviews.isEmpty()){
            averageRating =0.00;
        }
        for ( Review review: reviews) {
            double number = review.getRating();
            sum += number;
        }
        averageRating= sum/reviews.size();
    }
}


