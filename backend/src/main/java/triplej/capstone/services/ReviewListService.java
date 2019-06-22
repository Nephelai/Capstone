package triplej.capstone.services;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import triplej.capstone.dtos.ReviewResDto;
import triplej.capstone.entities.Reviews;
import triplej.capstone.entities.ReviewsRepository;

import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ReviewListService {
    private ReviewsRepository reviewsRepository;

    @Transactional
    public Reviews add(long id, Map<String, Object> m){

        SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");

        Reviews reviews = new Reviews();

        reviews.setRestaurant_id(id);
        reviews.setUser_id(String.valueOf(m.get("user_id")));
        reviews.setUser_pw(String.valueOf(m.get("user_pw")));
        reviews.setComment(String.valueOf(m.get("comments")));
        reviews.setGrade(Double.parseDouble(String.valueOf(m.get("grade"))));

        String curtime = format.format(System.currentTimeMillis());
        reviews.setTime(curtime);

        reviewsRepository.save(reviews);

        return reviews;
    }

    @Transactional
    public List<ReviewResDto> show(long id){
        List<ReviewResDto> res = new ArrayList<ReviewResDto>();

        List<Reviews> tmpReviews = reviewsRepository.findAll();
        for(int i = 0; i < tmpReviews.size(); i++){
            ReviewResDto mid = new ReviewResDto();
            if(tmpReviews.get(i).getRestaurant_id() == id){
                mid.setRestaurant_id(id);
                mid.setComment(tmpReviews.get(i).getComment());
                mid.setUser_id(tmpReviews.get(i).getUser_id());
                mid.setGrade(tmpReviews.get(i).getGrade());
                mid.setTime(tmpReviews.get(i).getTime());
                res.add(mid);
            }
        }
        return res;
    }
}
