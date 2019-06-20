package triplej.capstone.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import triplej.capstone.dtos.RestaurantEmailDto;
import triplej.capstone.entities.*;

import java.util.Optional;

@AllArgsConstructor
@Service
public class FindRestaurantsInfoService {
    private RestaurantsRepository restaurantsRepository;
    private ChineseFoodRepository chineseFoodRepository;
    private JapaneseFoodRepository japaneseFoodRepository;
    private KoreanFoodRepository koreanFoodRepository;
    private WesternFoodRepository westernFoodRepository;
    private BoonsikFoodRepository boonsikFoodRepository;

    private RestaurantEmailDto restaurantEmailDto;

    public RestaurantEmailDto findEmailById(String id) {
        Optional<Restaurants> tmpRestaurants = restaurantsRepository.findById(Long.parseLong(id));
        String tmpCategory = tmpRestaurants.get().getCategory();
        if(("ChineseFood").equals(tmpCategory)) {
            Optional<ChineseFood> tmpFood = chineseFoodRepository.findById(Long.parseLong(id));
            restaurantEmailDto.setId(id);
            restaurantEmailDto.setEmail(tmpFood.get().getPhoneNumber());
        }
        else if(("JapaneseFood").equals(tmpCategory)) {
            Optional<JapaneseFood> tmpFood = japaneseFoodRepository.findById(Long.parseLong(id));
            restaurantEmailDto.setId(id);
            restaurantEmailDto.setEmail(tmpFood.get().getPhoneNumber());
        }
        else if(("KoreanFood").equals(tmpCategory)) {
            Optional<KoreanFood> tmpFood = koreanFoodRepository.findById(Long.parseLong(id));
            restaurantEmailDto.setId(id);
            restaurantEmailDto.setEmail(tmpFood.get().getPhoneNumber());
        }
        else if(("WesternFood").equals(tmpCategory)) {
            Optional<WesternFood> tmpFood = westernFoodRepository.findById(Long.parseLong(id));
            restaurantEmailDto.setId(id);
            restaurantEmailDto.setEmail(tmpFood.get().getPhoneNumber());
        }
        else if(("BoonsikFood").equals(tmpCategory)) {
            Optional<BoonsikFood> tmpFood = boonsikFoodRepository.findById(Long.parseLong(id));
            restaurantEmailDto.setId(id);
            restaurantEmailDto.setEmail(tmpFood.get().getPhoneNumber());
        }

        return restaurantEmailDto;
    }
}
