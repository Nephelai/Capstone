package triplej.capstone.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import triplej.capstone.dtos.RestaurantResponseDto;
import triplej.capstone.entities.Restaurants;
import triplej.capstone.entities.RestaurantsRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RestaurantsListService {
    private RestaurantsRepository restaurantsRepository;

    @Transactional
    public RestaurantResponseDto findRestaurant() {
        Optional<Restaurants> restaurant = restaurantsRepository.findById(new Long(1));
        RestaurantResponseDto restaurantResponseDto = RestaurantResponseDto.builder()
                .name(restaurant.get().getName())
                .currentTable(Integer.toString(restaurant.get().getCurrentTable()))
                .totalTable(Integer.toString(restaurant.get().getTotalTable()))
                .build();

        restaurantResponseDto.setRank("1");
        restaurantResponseDto.setRemainTime("5");

        return restaurantResponseDto;
    }
}
