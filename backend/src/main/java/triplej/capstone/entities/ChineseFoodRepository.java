package triplej.capstone.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface ChineseFoodRepository extends JpaRepository<ChineseFood, Long> {
    @Query(value = "SELECT ch FROM ChineseFood ch WHERE ch.restaurant_id = :restaurant_id")
    List<ChineseFood> findByRId(@Param("restaurant_id") Long restaurant_id);
}
