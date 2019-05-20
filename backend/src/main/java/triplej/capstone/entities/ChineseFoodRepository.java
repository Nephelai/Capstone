package triplej.capstone.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface ChineseFoodRepository extends JpaRepository<ChineseFood, Long> {
    @Query("SELECT * FROM  chinese_food NATURAL JOIN current_table WHERE chinese_food.restaurants_id = current_table.restaurants_id ORDER BY current_table.id DESC")
    //Stream<ChineseFood> findAllDesc();
    Stream<ChineseFood> findAllDesc();

}
