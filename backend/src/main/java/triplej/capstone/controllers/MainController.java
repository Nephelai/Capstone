package triplej.capstone.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import opg.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.Controller;
import triplej.capstone.dtos.RestaurantResponseDto;

@CrossOrigin(origins = "*")
@Controller
@AllArgsConstructor
public class MainController {
    @GetMapping("/")
    public String main() {
        return "index";
    }
}
