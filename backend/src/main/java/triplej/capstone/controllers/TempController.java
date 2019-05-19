package triplej.capstone.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import opg.springframework.web.bind.annotation.CrossOrigin;
=======
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> origin/feature/Simple_Request_#18
import org.springframework.web.bind.annotation.RestController;
import triplej.capstone.dtos.RestaurantResponseDto;
import triplej.capstone.services.RestaurantsListService;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class TempController {
    @Autowired
    RestaurantsListService restaurantsListService;

    @GetMapping("/categories/{id}")
    public RestaurantResponseDto hello(@PathVariable int id) {
        // id = categoryId
        RestaurantResponseDto restaurantResponseDto;

        restaurantResponseDto = restaurantsListService.findRestaurant();
        return restaurantResponseDto;
    }
}
