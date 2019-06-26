package triplej.capstone.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import triplej.capstone.dtos.RestaurantEmailDto;
import triplej.capstone.entities.*;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class FindRestaurantsInfoService {
    @Autowired
    private RestaurantsRepository restaurantsRepository;
    @Autowired
    private ChineseFoodRepository chineseFoodRepository;
    @Autowired
    private JapaneseFoodRepository japaneseFoodRepository;
    @Autowired
    private KoreanFoodRepository koreanFoodRepository;
    @Autowired
    private WesternFoodRepository westernFoodRepository;
    @Autowired
    private BoonsikFoodRepository boonsikFoodRepository;

    public String findEmailById(Long id) {
        System.out.println(id);
        Optional<Restaurants> tmpRestaurants = restaurantsRepository.findById(id);
        String tmpCategory = tmpRestaurants.get().getCategory();
        log.info(tmpRestaurants.get().getCategory());
        if(("ChineseFood").equals(tmpCategory)) {
            List<ChineseFood> tmpFood = chineseFoodRepository.findByRId(id);
            return tmpFood.get(0).getPhoneNumber();
        }
        else if(("JapaneseFood").equals(tmpCategory)) {
            List<JapaneseFood> tmpFood = japaneseFoodRepository.findByRId(id);
            return tmpFood.get(0).getPhoneNumber();
        }
        else if(("KoreanFood").equals(tmpCategory)) {
            List<KoreanFood> tmpFood = koreanFoodRepository.findByRId(id);
            return tmpFood.get(0).getPhoneNumber();
        }
        else if(("WesternFood").equals(tmpCategory)) {
            List<WesternFood> tmpFood = westernFoodRepository.findByRId(id);
            return tmpFood.get(0).getPhoneNumber();
        }
        else if(("BoonsikFood").equals(tmpCategory)) {
            List<BoonsikFood> tmpFood = boonsikFoodRepository.findByRId(id);
            return tmpFood.get(0).getPhoneNumber();
        }

        return "fail";
    }
}
