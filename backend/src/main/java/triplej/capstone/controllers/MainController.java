package triplej.capstone.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class MainController {
    @GetMapping("/")
    public String home() {
        return "index.html";
    }
}
