package triplej.capstone.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import triplej.capstone.dtos.RestaurantResponseDto;
import triplej.capstone.services.RestaurantsListService;

@RestController
@AllArgsConstructor
public class TempController {
    @GetMapping("/categories/{id}")
    public RestaurantResponseDto hello(@PathVariable int id) {
        // id = categoryId
        RestaurantResponseDto restaurantResponseDto;

        RestaurantsListService restaurantsListService = new RestaurantsListService();
        restaurantResponseDto = restaurantsListService.findRestaurant();
        return restaurantResponseDto;
    }
}
