package triplej.capstone.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import triplej.capstone.dtos.RestaurantResponseDto;
import triplej.capstone.services.RestaurantsListService;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TempControllerTest {

//    @Autowired
//    RestaurantsListService restaurantsListService;
    @Autowired
    protected TestRestTemplate restTemplate;

//    private MockMvc mockMvc;
//
//    @MockBean
//    TempController tempController;
//
//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(tempController).build();
//    }

    @Test
    public void 응답_확인() {
        // when
        String body = this.restTemplate.getForObject("/categories/2", String.class);

        // then
        //assertThat(body).contains("인하각");
        assertThat(body, containsString("인하각"));
//        given(this.tempController.hello(2))
//                .willReturn(new RestaurantResponseDto(1, "인하각", 0, 20, 5));
//
//        mockMvc.perform(get("/categories/2"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$['name']", containsString("인하각")))
//                .andDo(print());
    }
}