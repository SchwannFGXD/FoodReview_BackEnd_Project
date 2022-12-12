package model;
import javax.persistence.*;
import java.time.LocalDate;


@Entity(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="rating")
    private double rating;

    @Column(name ="review_text")
    private String reviewText;

    @Column(name ="date")
    private LocalDate date;

    public Review(double rating, String reviewText, LocalDate date){
        this.rating = rating;
        this.reviewText = reviewText;
        this.date = date;
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
}
