package triplej.capstone.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import triplej.capstone.dtos.RestaurantEmailDto;
import triplej.capstone.entities.*;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class FindRestaurantsInfoService {
    private RestaurantsRepository restaurantsRepository;
    private ChineseFoodRepository chineseFoodRepository;
    private JapaneseFoodRepository japaneseFoodRepository;
    private KoreanFoodRepository koreanFoodRepository;
    private WesternFoodRepository westernFoodRepository;
    private BoonsikFoodRepository boonsikFoodRepository;

    public String findEmailById(String id) {
        System.out.println(id);
        Optional<Restaurants> tmpRestaurants = restaurantsRepository.findById(Long.parseLong(id));
        String tmpCategory = tmpRestaurants.get().getCategory();
        log.info(tmpRestaurants.get().getCategory());
        if(("ChineseFood").equals(tmpCategory)) {
            List<ChineseFood> tmpFood = chineseFoodRepository.findByRId(Long.parseLong(id));
            return tmpFood.get(0).getPhoneNumber();
        }
        else if(("JapaneseFood").equals(tmpCategory)) {
            List<JapaneseFood> tmpFood = japaneseFoodRepository.findByRId(Long.parseLong(id));
            return tmpFood.get(0).getPhoneNumber();
        }
        else if(("KoreanFood").equals(tmpCategory)) {
            List<KoreanFood> tmpFood = koreanFoodRepository.findByRId(Long.parseLong(id));
            return tmpFood.get(0).getPhoneNumber();
        }
        else if(("WesternFood").equals(tmpCategory)) {
            List<WesternFood> tmpFood = westernFoodRepository.findByRId(Long.parseLong(id));
            return tmpFood.get(0).getPhoneNumber();
        }
        else if(("BoonsikFood").equals(tmpCategory)) {
            List<BoonsikFood> tmpFood = boonsikFoodRepository.findByRId(Long.parseLong(id));
            return tmpFood.get(0).getPhoneNumber();
        }

        return "fail";
    }
}
