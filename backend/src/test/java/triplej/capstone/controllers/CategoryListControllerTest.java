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
public class CategoryListControllerTest {

    @Autowired
    protected TestRestTemplate restTemplate;

    private MockMvc mockMvc;

    @MockBean
    CategoryListController categoryListController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryListController).build();
    }

    @Test
    public void 응답_확인() throws Exception {
        // when
        //String body = this.restTemplate.getForObject("/categories/0", String.class);

        // then
        //assertThat(body).contains("인하각");
        //assertThat(body, containsString("인하각"));

        mockMvc.perform(get("/categories/0/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
//                .andExpect(jsonPath("$['rank']", containsString("1")))
//                .andExpect(jsonPath("$['rank']", containsString("2")))

    }
}