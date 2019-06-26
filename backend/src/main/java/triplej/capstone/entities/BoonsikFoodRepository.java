package triplej.capstone.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoonsikFoodRepository extends JpaRepository<BoonsikFood, Long> {
    @Query(value = "SELECT bo FROM BoonsikFood bo WHERE bo.restaurant_id = :restaurant_id")
    List<BoonsikFood> findByRId(@Param("restaurant_id") Long restaurant_id);
}
