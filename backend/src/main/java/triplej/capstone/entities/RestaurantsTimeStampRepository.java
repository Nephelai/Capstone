package triplej.capstone.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface RestaurantsTimeStampRepository extends JpaRepository<RestaurantsTimeStamp, Long> {
    @Query("SELECT t FROM RestaurantsTimeStamp t ORDER BY t.time ASC")
    Stream<RestaurantsTimeStamp> findAllByDesc(String restaurant_id);
}
