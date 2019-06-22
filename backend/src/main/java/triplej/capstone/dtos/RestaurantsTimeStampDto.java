package triplej.capstone.dtos;

import lombok.*;
import triplej.capstone.entities.Restaurants;
import triplej.capstone.entities.RestaurantsTimeStamp;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantsTimeStampDto {
    public String id;
    public String restaurant_id;
    public String time;

    public RestaurantsTimeStampDto(RestaurantsTimeStamp entity) {
        id = Long.toString(entity.getId());
        restaurant_id = Long.toString(entity.getRestaurant_id());
        time = entity.getTime();
    }
}
