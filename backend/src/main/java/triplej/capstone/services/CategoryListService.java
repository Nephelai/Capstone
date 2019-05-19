package triplej.capstone.services;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import triplej.capstone.dtos.CategoryResDto;
import triplej.capstone.entities.*;

import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class CategoryListService {

    private ChineseFoodRepository chineseFoodRepository;
    private JapaneseFoodRepository japaneseFoodRepository;
    private KoreanFoodRepository koreanFoodRepository;
    private WesternFoodRepository westernFoodRepository;

    @Transactional(readOnly = true)
    public List<CategoryResDto> findRestaurantInCategory(int category_id) {
        List<CategoryResDto> resCategory;
        switch (category_id) {
            case 1:
                Stream<ChineseFood> tmpChinese = chineseFoodRepository.findAllDesc();

                for (int i = 1; i < tmpChinese.size() + 1; i++) {
                    resCategory.add(CategoryResDto.builder()
                            .rank(String.valueOf(i))
                            .name(tmpChinese.get(i).getName())
                            .currentTable(tmpChinese.get(i).)
                            .
                            .build()
                    );
                }

                resCategory = CategoryResDto.builder()
                        .name(tmpChinese.map().)
        }
    }
}
