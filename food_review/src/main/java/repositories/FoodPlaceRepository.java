package repositories;

import model.FoodPlace;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodPlaceRepository extends JpaRepository<FoodPlace, Long> {
}
