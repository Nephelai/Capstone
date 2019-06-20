package triplej.capstone.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KoreanFoodRepository extends JpaRepository<KoreanFood, Long>{
    @Query(value = "SELECT kr FROM KoreanFood kr WHERE kr.restaurant_id = :restaurant_id")
    List<KoreanFood> findByRId(@Param("restaurant_id") Long restaurant_id);
}
