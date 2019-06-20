package triplej.capstone.services;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import triplej.capstone.dtos.CategoryResDto;
import triplej.capstone.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class CategoryListService {

    private ChineseFoodRepository chineseFoodRepository;
    private JapaneseFoodRepository japaneseFoodRepository;
    private KoreanFoodRepository koreanFoodRepository;
    private WesternFoodRepository westernFoodRepository;
    private BoonsikFoodRepository boonsikFoodRepository;
    private RestaurantsRepository restaurantsRepository;

    RestaurantListService restaurantListService;


    @Transactional(readOnly = true)
    public List<CategoryResDto> findRestaurantInCategory(int category_id) {
        List<CategoryResDto> resCategory = new ArrayList<CategoryResDto>();
        switch (category_id) {
            case 0:
                List<KoreanFood> tmpKorean = koreanFoodRepository.findAll();
                for(int i = 0; i < tmpKorean.size(); i++){
                    CategoryResDto tmp = CategoryResDto.builder()
                            .id(Long.toString((tmpKorean).get(i).getId()))
                            .name(tmpKorean.get(i).getName())
                            .currentTable(String.valueOf(tmpKorean.get(i).getCurrentTable()))
                            .totalTable(String.valueOf(tmpKorean.get(i).getTotalTable()))
                            .remainTime("10")
                            .lat(String.valueOf(tmpKorean.get(i).getLat()))
                            .lng(String.valueOf(tmpKorean.get(i).getLng()))
                            .phoneNumber(tmpKorean.get(i).getPhoneNumber())
                            .build();
                    resCategory.add(tmp);
                }
                break;
            case 1:
                List<ChineseFood> tmpChinese = chineseFoodRepository.findAll();
                for(int i = 0; i < tmpChinese.size(); i++){
                    CategoryResDto tmp = CategoryResDto.builder()
                            .id(Long.toString((tmpChinese).get(i).getId()))
                            .name(tmpChinese.get(i).getName())
                            .currentTable(String.valueOf(tmpChinese.get(i).getCurrentTable()))
                            .totalTable(String.valueOf(tmpChinese.get(i).getTotalTable()))
                            .remainTime("10")
                            .lat(String.valueOf(tmpChinese.get(i).getLat()))
                            .lng(String.valueOf(tmpChinese.get(i).getLng()))
                            .phoneNumber(tmpChinese.get(i).getPhoneNumber())
                            .build();
                    resCategory.add(tmp);
                }
                break;
            case 2:
                List<JapaneseFood> tmpJapanese = japaneseFoodRepository.findAll();
                for(int i = 0; i < tmpJapanese.size(); i++){
                    CategoryResDto tmp = CategoryResDto.builder()
                            .id(Long.toString((tmpJapanese).get(i).getId()))
                            .name(tmpJapanese.get(i).getName())
                            .currentTable(String.valueOf(tmpJapanese.get(i).getCurrentTable()))
                            .totalTable(String.valueOf(tmpJapanese.get(i).getTotalTable()))
                            .remainTime("10")
                            .lat(String.valueOf(tmpJapanese.get(i).getLat()))
                            .lng(String.valueOf(tmpJapanese.get(i).getLng()))
                            .phoneNumber(tmpJapanese.get(i).getPhoneNumber())
                            .build();
                    resCategory.add(tmp);
                }
                break;
            case 3:
                List<WesternFood> tmpWestern = westernFoodRepository.findAll();
                for(int i = 0; i < tmpWestern.size(); i++){
                    CategoryResDto tmp = CategoryResDto.builder()
                            .id(Long.toString((tmpWestern).get(i).getId()))
                            .name(tmpWestern.get(i).getName())
                            .currentTable(String.valueOf(tmpWestern.get(i).getCurrentTable()))
                            .totalTable(String.valueOf(tmpWestern.get(i).getTotalTable()))
                            .remainTime("10")
                            .lat(String.valueOf(tmpWestern.get(i).getLat()))
                            .lng(String.valueOf(tmpWestern.get(i).getLng()))
                            .phoneNumber(tmpWestern.get(i).getPhoneNumber())
                            .build();
                    resCategory.add(tmp);
                }
                break;
            case 4:
                List<BoonsikFood> tmpBoonsik = boonsikFoodRepository.findAll();
                for(int i = 0; i < tmpBoonsik.size(); i++){
                    CategoryResDto tmp = CategoryResDto.builder()
                            .id(Long.toString((tmpBoonsik).get(i).getId()))
                            .name(tmpBoonsik.get(i).getName())
                            .currentTable(String.valueOf(tmpBoonsik.get(i).getCurrentTable()))
                            .totalTable(String.valueOf(tmpBoonsik.get(i).getTotalTable()))
                            .remainTime("10")
                            .lat(String.valueOf(tmpBoonsik.get(i).getLat()))
                            .lng(String.valueOf(tmpBoonsik.get(i).getLng()))
                            .phoneNumber(tmpBoonsik.get(i).getPhoneNumber())
                            .build();
                    resCategory.add(tmp);
                }
                break;
            case 5:
                List<Restaurants> tmpRestaurant = restaurantsRepository.findAll();
                for(int i = 0; i < tmpRestaurant.size(); i++){
                    CategoryResDto tmp = restaurantListService.findInfo(tmpRestaurant.get(i).getCategory(), tmpRestaurant.get(i).getId());
                    resCategory.add(tmp);
                }

                break;
            default:
                break;
        }
        return resCategory;
    }
}
