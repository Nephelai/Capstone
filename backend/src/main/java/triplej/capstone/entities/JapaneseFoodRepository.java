package triplej.capstone.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JapaneseFoodRepository extends JpaRepository<JapaneseFood, Long> {
    @Query(value = "SELECT jp FROM JapaneseFood jp WHERE jp.restaurant_id = :restaurant_id")
    List<JapaneseFood> findByRId(@Param("restaurant_id") Long restaurant_id);
}
