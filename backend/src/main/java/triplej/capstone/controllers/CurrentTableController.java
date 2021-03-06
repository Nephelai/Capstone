package triplej.capstone.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import triplej.capstone.dtos.CurrentTableDto;
import triplej.capstone.services.CurrentTableService;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class CurrentTableController {
    @Autowired
    CurrentTableService currentTableService;

    @GetMapping("/api/increment/{category_id}/{restaurant_id}")
    public CurrentTableDto increaseCurrentTable(@PathVariable("category_id") int category_id, @PathVariable("restaurant_id") long id){
        return  currentTableService.increment(category_id, id);
    }

    @GetMapping("/api/decrement/{category_id}/{restaurant_id}")
    public CurrentTableDto decreaseCurrentTable(@PathVariable("category_id") int category_id, @PathVariable("restaurant_id") long id){
        return  currentTableService.decrement(category_id, id);
    }

}
