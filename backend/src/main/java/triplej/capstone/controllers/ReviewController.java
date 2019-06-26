package triplej.capstone.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import triplej.capstone.dtos.ReviewResDto;
import triplej.capstone.entities.Reviews;
import triplej.capstone.services.ReviewListService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class ReviewController {
    @Autowired
    ReviewListService reviewListService;

    // add review
    @PostMapping("/comments/{restaurant_id}")
    public Reviews addReview(@PathVariable("restaurant_id") long id, @RequestBody Map<String, Object> m){
        // System.out.println(m.get("user_id"));
        return reviewListService.add(id, m);
    }

    // show review list
    @GetMapping("/comments/{restaurant_id}")
    public List<ReviewResDto> showReviewList(@PathVariable("restaurant_id") long id) {
        return reviewListService.show(id);
    }

}
