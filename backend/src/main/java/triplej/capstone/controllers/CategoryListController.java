package triplej.capstone.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import triplej.capstone.dtos.CategoryResDto;
import triplej.capstone.dtos.RestaurantResponseDto;
import triplej.capstone.services.CategoryListService;
import triplej.capstone.services.RestaurantsListService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class CategoryListController {
    @Autowired
    CategoryListService restaurantsListService;

    @GetMapping("/categories/{id}")
    public List<CategoryResDto> findList(@PathVariable(name = "id") int id) {
        // id = categoryId

        return restaurantsListService.findRestaurantInCategory(id);
    }
}
