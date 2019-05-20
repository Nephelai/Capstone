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
    private List<CategoryResDto> resCategory;

    @Transactional(readOnly = true)
    public List<CategoryResDto> findRestaurantInCategory(int category_id) {
        List<CategoryResDto> resCategory = new ArrayList<CategoryResDto>();
        switch (category_id) {
            case 1:
                List<ChineseFood> tmpChinese = chineseFoodRepository.findAll();
                for(int i = 0; i < tmpChinese.size(); i++){
                    CategoryResDto tmp = CategoryResDto.builder()
                            .rank(String.valueOf(i + 1))
                            .name(tmpChinese.get(i).getName())
                            .currentTable(String.valueOf(tmpChinese.get(i).getCurrentTable()))
                            .totalTable(String.valueOf(tmpChinese.get(i).getTotalTable()))
                            .remainTime("10")
                            .build();
                    resCategory.add(tmp);
                }
                break;
            case 2:
                List<JapaneseFood> tmpJapanese = japaneseFoodRepository.findAll();
                for(int i = 0; i < tmpJapanese.size(); i++){
                    CategoryResDto tmp = CategoryResDto.builder()
                            .rank(String.valueOf(i + 1))
                            .name(tmpJapanese.get(i).getName())
                            .currentTable(String.valueOf(tmpJapanese.get(i).getCurrentTable()))
                            .totalTable(String.valueOf(tmpJapanese.get(i).getTotalTable()))
                            .remainTime("10")
                            .build();
                    resCategory.add(tmp);
                }
                break;
            case 3:
                List<KoreanFood> tmpKorean = koreanFoodRepository.findAll();
                for(int i = 0; i < tmpKorean.size(); i++){
                    CategoryResDto tmp = CategoryResDto.builder()
                            .rank(String.valueOf(i + 1))
                            .name(tmpKorean.get(i).getName())
                            .currentTable(String.valueOf(tmpKorean.get(i).getCurrentTable()))
                            .totalTable(String.valueOf(tmpKorean.get(i).getTotalTable()))
                            .remainTime("10")
                            .build();
                    resCategory.add(tmp);
                }
                break;
            case 4:
                List<WesternFood> tmpWestern = westernFoodRepository.findAll();
                for(int i = 0; i < tmpWestern.size(); i++){
                    CategoryResDto tmp = CategoryResDto.builder()
                            .rank(String.valueOf(i + 1))
                            .name(tmpWestern.get(i).getName())
                            .currentTable(String.valueOf(tmpWestern.get(i).getCurrentTable()))
                            .totalTable(String.valueOf(tmpWestern.get(i).getTotalTable()))
                            .remainTime("10")
                            .build();
                    resCategory.add(tmp);
                }
                break;
            default:
                break;
        }
        return resCategory;
    }
}
