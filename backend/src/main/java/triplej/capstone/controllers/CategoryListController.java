package triplej.capstone.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import triplej.capstone.dtos.CategoryResDto;
import triplej.capstone.services.CategoryListService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class CategoryListController {
    @Autowired
    CategoryListService categoryListService;

    @GetMapping("front/categories/{id}")
    public List<CategoryResDto> findList(@PathVariable(name = "id") int id) {
        // id = categoryId

        return categoryListService.findRestaurantInCategory(id);
    }
}
