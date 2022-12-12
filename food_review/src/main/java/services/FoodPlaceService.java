package services;
import model.FoodPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.FoodPlaceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoodPlaceService {

    @Autowired
    FoodPlaceRepository foodPlaceRepository;

    public List<FoodPlace> getAllFoodPlaces() {return foodPlaceRepository.findAll();}

    public Optional<FoodPlace> getFoodPlaceById(Long id) { return foodPlaceRepository.findById(id);}

    public void addFoodPlace(FoodPlace foodplace) {
        foodPlaceRepository.save(foodplace);
    }

    public void removeFoodPlaceById(Long id) { foodPlaceRepository.deleteById(id);}

    public void updateFoodPlace(FoodPlace foodPlace, Long id){
        FoodPlace foodPlaceToUpdate = foodPlaceRepository.findById(id).get();
        foodPlaceToUpdate.setName(foodPlace.getName());
        foodPlaceToUpdate.setFoodType(foodPlace.getFoodType());
        foodPlaceToUpdate.setOpeningHours(foodPlace.getOpeningHours());
        foodPlaceToUpdate.setWebsite(foodPlace.getWebsite());
        foodPlaceRepository.save(foodPlaceToUpdate);
    }


}
