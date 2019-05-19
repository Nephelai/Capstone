package triplej.capstone.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Controller
@AllArgsConstructor
public class MainController {
    @GetMapping("/")
    public String main() {
        return "index.html";
    }
}
