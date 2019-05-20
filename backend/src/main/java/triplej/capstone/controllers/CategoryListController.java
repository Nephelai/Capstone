package triplej.capstone.controllers;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import triplej.capstone.dtos.RestaurantResponseDto;
import triplej.capstone.services.RestaurantsListService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class CategoryListController {
    @Autowired
    RestaurantsListService restaurantsListService;

    @GetMapping("/categories/{id}")
    public List<CategoryListController> findList(@PathVariable int id) {
        // id = categoryId
        RestaurantResponseDto restaurantResponseDto;

        restaurantResponseDto = restaurantsListService.findRestaurant();
        return restaurantResponseDto;
    }
=======
public class CategoryListController {
>>>>>>> Start API Service Development
}
