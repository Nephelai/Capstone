package triplej.capstone.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import triplej.capstone.dtos.RestaurantResponseDto;

@RestController
@AllArgsConstructor
public class TempController {
    @GetMapping("/categories")
    public RestaurantResponseDto hello() {
        RestaurantResponseDto restaurantResponseDto;


        return restaurantResponseDto;
    }
}
