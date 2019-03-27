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

    @After
    public void cleanup() {
        restaurantsRepository.deleteAll();
    }

    @Test
    public void 저장_불러오기() {
        // given
        restaurantsRepository.save(Restaurants.builder()
            .name("인하각")
            .phoneNumber("01012345678")
            .totalTable(20)
            .build());

        // when
        List<Restaurants> restaurantsList = restaurantsRepository.findAll();

        // then
        Restaurants restaurants = restaurantsList.get(0);
        assertThat(restaurants.getName(), is("인하각"));
        assertThat(restaurants.getPhoneNumber(), is("01012345678"));
        assertThat(restaurants.getTotalTable(), is(20));
    }
}