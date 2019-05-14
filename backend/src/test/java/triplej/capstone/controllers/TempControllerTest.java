package triplej.capstone.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import triplej.capstone.services.RestaurantsListService;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TempControllerTest {

    @Autowired
    RestaurantsListService restaurantsListService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 응답_확인() {
        // when
        String body = this.restTemplate.getForObject("/categories/2", String.class);

        // then
        //assertThat(body).contains("인하각");
        assertThat(body, containsString("인하각"));
    }
}