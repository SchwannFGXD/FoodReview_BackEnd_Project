# Team 1 - Best Bytes 
<p align = "center">
<img width="300" alt="Screenshot 2022-12-15 at 11 13 42" src="https://user-images.githubusercontent.com/60015635/207845276-0b5715fa-7549-4253-8e6e-7c64dc28177f.png">
</p>

Best Bytes alllows users to submit a food review, further interaction is also available through deleting and updating reviews and so much more.
<p align = "center">
Taking life one bite at a time
</p>

## Project Description
We wanted to create a space where food lovers, just like us, can share their food related experiences all in one place. 

This application gives the users the space to add, update and delete reviews to the database - we have created specific classes for this with properties that we deemed to be the most important for creating these reviews.

## Key Features 
Beyond our basic CRUD functionalilty, we decided to implement a few key features to increase the user's ability to interact with the API. These features include a randomisation function to allow to user to find a foodplace at random if they cannot decide where to eat. We also use derived queries to create filters (eg: filter foodplaces based on foodtype among others).

**We have created:** Classes for user, review, foodplace along with their respected services, repositories and controllers.


## MVP ##  

- Create user, review and foodplace.
- Read users, reviews and foodplaces.
- Update users, reviews and foodplaces.
- Delete users, reviews and foodplaces.
- Add review method in User to attach a review.

### UML MVP ###
<img width="986" alt="UML MVP" src="https://user-images.githubusercontent.com/60015635/207842537-5b50a8c3-2595-44bf-b323-1c7b9f1f3b09.png">

### ERD  ###

We used two one-to-many relationships, so one user to many reviews and one food place to many reviews.
<img width="986" alt="ERD MVP" src="https://user-images.githubusercontent.com/60015635/207842999-a269756e-bfb7-488a-a82e-25219a526afb.png">

### MVC ###
<img width="1408" alt="Screenshot 2022-12-15 at 11 48 20" src="https://user-images.githubusercontent.com/60015635/207851793-3c86a793-c404-40dd-8f59-5b2cb67d0172.png">

## Extensions ##

- Delete review method in User and Review (to allow moderators to also delete inappropriate reviews).
- Average rating method in FoodPlace class.
- Derived queries for filtering User's name, FoodPlace's name, food type and average ratings.
- Changed openingHours: String to openingHour:LocalTime and closingHour: LocalTime.


## Tech Stack ##
- Java
- Spring Framework (dependencies: Spring Web, Spring Boot DevTools, PostgreSQL Driver, Spring Data JPA
- Postman
- Postico
- Terminal
- Git and GitHub

## Installation Instructions ##
TO copy our git repo, please follow the instructions below:
- Git clone SSH Key git clone git@github.com:e-b-m/team_1_food_review.git 
- Create a database called food_review in the terminal (createdb food_review)

## Routes ##
localhost:8080...
|HTTP Request Path             |Request Type|                  Description            |
|:----------------------------:|:-----------|:----------------------------------------|
|.../user                      |GET         | Display all users                       |
|.../user/1                    |GET         | Find user by id                         |
|.../user/username?name=Zsolt  |GET         | Find user by name                       |
|.../user/1/reviews            |GET         |Get all reviews from the user by their id|
|.../user/1/foodplace          |GET         |Get food places from user                |
|.../user                      |POST        |Add a new user                           |
|.../user/1                    |DELETE      |Delete user                              |
|.../user/1                    |PUT         |Update user                              |
|.../foodplace                 |GET         |Display all food places                  |
|.../foodplace/1               |GET         |Find food place by id                    |
|.../foodplace/name?name=Amigos          |GET         |Find food place by name                  |
|.../foodplace/foodtype?foodType=Japanese|GET         |Filter food places by food type          |
|.../foodplace/random          |GET         |Find a random food place                 |
|.../foodplace/1/reviews       |GET         |Get all reviews from a food place        |
|.../foodplace/1/average_rating|GET         |Get average rating of a food place       |
|.../foodplace                 |POST        | Add a new food place                    |
|.../foodplace/1               |DELETE      |Remove a food place                      |
|.../foodplace/1               |PUT         |Update food place                        |
|.../review                    |GET         |Display all reviews                      |
|.../review/1                  |GET         |Find review by id                        |
|.../review                    |POST        |Add a new review                         |
|.../review/1                  |DELETE      |Remove a review                          |
|.../review/1                  |UPDATE      |Update a review                          |



## Testing ##
We decided to test all our routes in Postman and Postico.

Here is a sample of our testing in Postman - it shows our GET request to display all the reviews.

<img width="716" alt="Screenshot 2022-12-15 at 14 20 53" src="https://user-images.githubusercontent.com/110283546/207885190-c20d8dcf-af11-40e4-aee5-eb2859957dfc.png">


This is what our Review table looks like in Postico.

<img width="851" alt="Screenshot 2022-12-15 at 11 31 03" src="https://user-images.githubusercontent.com/110283546/207850516-1520efb1-cf4b-474d-9cc0-45af4c0a55cb.png">


Here is the code from the Review Controller.

`    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.displayAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }`



## Thank you ##
Thank you to all the trainers for helping and inspiring us, and thank you to everyone on our cohort for supporting us. 

See you next year 😘

