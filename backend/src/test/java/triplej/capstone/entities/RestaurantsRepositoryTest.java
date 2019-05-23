package triplej.capstone.entities;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantsRepositoryTest {
    @Autowired
    RestaurantsRepository restaurantsRepository;

    private Restaurants restaurants;

    @After
    public void cleanup() {
        restaurantsRepository.delete(restaurants);
    }

    @Test
    public void 저장_불러오기() {
        // given
        restaurants = Restaurants.builder()
                .category("KoreanFood")
                .build();
        restaurantsRepository.save(restaurants);

        // when
        List<Restaurants> restaurantsList = restaurantsRepository.findAll();

        // then
        Restaurants tmp_rest = restaurantsList.get(restaurantsList.size() - 1);
        assertThat(tmp_rest.getCategory(), is("KoreanFood"));
    }
}