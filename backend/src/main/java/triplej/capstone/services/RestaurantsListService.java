package triplej.capstone.services;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import triplej.capstone.dtos.RestaurantResponseDto;
import triplej.capstone.entities.Restaurants;
import triplej.capstone.entities.RestaurantsRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@NoArgsConstructor
@Service
public class RestaurantsListService {
    private RestaurantsRepository restaurantsRepository;

    @Transactional
    public RestaurantResponseDto findRestaurant() {
        Optional<Restaurants> restaurant = restaurantsRepository.findById(new Long(1));
        RestaurantResponseDto restaurantResponseDto = RestaurantResponseDto.builder()
                .name(restaurant.get().getName())
                .currentTable(restaurant.get().getCurrentTable())
                .totalTable(restaurant.get().getTotalTable())
                .build();

        restaurantResponseDto.setRank(1);
        restaurantResponseDto.setRemainTime(5);

        return restaurantResponseDto;
    }
}
