package triplej.capstone.controllers;

import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Controller
@AllArgsConstructor
public class MainController implements ErrorController {
    @GetMapping({"/","/error"})
    public String main() {
        return "index.html";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
