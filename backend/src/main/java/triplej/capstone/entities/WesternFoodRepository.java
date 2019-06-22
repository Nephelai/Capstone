package triplej.capstone.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WesternFoodRepository extends JpaRepository<WesternFood, Long> {
    @Query(value = "SELECT we FROM WesternFood we WHERE we.restaurant_id = :restaurant_id")
    List<WesternFood> findByRId(@Param("restaurant_id") Long restaurant_id);
}
