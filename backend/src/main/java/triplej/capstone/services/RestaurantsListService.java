package triplej.capstone.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import triplej.capstone.dtos.RestaurantResponseDto;
import triplej.capstone.entities.RestaurantsRepository;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class RestaurantsListService {
    private RestaurantsRepository restaurantsRepository;

    @Transactional
    public RestaurantResponseDto findRestaurant() {
        return restaurantsRepository.findById(new Long(1));
    }
}
