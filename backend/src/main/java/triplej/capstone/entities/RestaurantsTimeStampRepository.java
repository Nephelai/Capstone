package triplej.capstone.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface RestaurantsTimeStampRepository extends JpaRepository<RestaurantsTimeStamp, Long> {
    @Query(value = "SELECT t FROM RestaurantsTimeStamp t WHERE t.restaurant_id = :restaurant_id ORDER BY t.time ASC")
    Stream<RestaurantsTimeStamp> findAllByAsc(@Param("restaurant_id") Long restaurant_id);
}
