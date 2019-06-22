package triplej.capstone.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import triplej.capstone.dtos.CategoryResDto;
import triplej.capstone.dtos.CurrentTableDto;
import triplej.capstone.entities.*;

import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantListService {
    private BoonsikFoodRepository boonsikFoodRepository;
    private ChineseFoodRepository chineseFoodRepository;
    private JapaneseFoodRepository japaneseFoodRepository;
    private KoreanFoodRepository koreanFoodRepository;
    private WesternFoodRepository westernFoodRepository;
    private ReviewsRepository reviewsRepository;

    @Transactional(readOnly = true)
    public CategoryResDto findInfo(String category, long id) {
        int category_id = -1;
        if(category.equals("KoreanFood"))
            category_id = 0;
        else if(category.equals("ChineseFood"))
            category_id = 1;
        else if(category.equals("JapaneseFood"))
            category_id = 2;
        else if(category.equals("WesternFood"))
            category_id = 3;
        else if(category.equals("BoonsikFood"))
            category_id = 4;

        switch (category_id) {
            case 0:
                List<KoreanFood> tmpKorean = koreanFoodRepository.findAll();
                for(int i = 0; i < tmpKorean.size(); i++){
                    if(tmpKorean.get(i).getRestaurant_id() == id) {
                        double grade = 0;
                        int cnt = 0;
                        double ans = 0;
                        List<Reviews> tmpReview = reviewsRepository.findAll();
                        for(int a = 0; a < tmpReview.size(); a++){
                            if(tmpKorean.get(i).getRestaurant_id() == tmpReview.get(a).getRestaurant_id()){
                                grade += tmpReview.get(a).getGrade();
                                cnt++;
                            }
                        }
                        ans = grade / cnt;

                        CategoryResDto res = CategoryResDto.builder()
                                .id(Long.toString((tmpKorean).get(i).getRestaurant_id()))
                                .name(tmpKorean.get(i).getName())
                                .currentTable(String.valueOf(tmpKorean.get(i).getCurrentTable()))
                                .totalTable(String.valueOf(tmpKorean.get(i).getTotalTable()))
                                .remainTime("10")
                                .lat(String.valueOf(tmpKorean.get(i).getLat()))
                                .lng(String.valueOf(tmpKorean.get(i).getLng()))
                                .phoneNumber(tmpKorean.get(i).getPhoneNumber())
                                .grade(ans)
                                .build();
                        return res;
                    }
                }
                break;
            case 1:
                List<ChineseFood> tmpChinese = chineseFoodRepository.findAll();
                for(int i = 0; i < tmpChinese.size(); i++){
                    if(tmpChinese.get(i).getRestaurant_id() == id) {
                        double grade = 0;
                        int cnt = 0;
                        double ans = 0;
                        List<Reviews> tmpReview = reviewsRepository.findAll();
                        for(int a = 0; a < tmpReview.size(); a++){
                            if(tmpChinese.get(i).getRestaurant_id() == tmpReview.get(a).getRestaurant_id()){
                                grade += tmpReview.get(a).getGrade();
                                cnt++;
                            }
                        }
                        ans = grade / cnt;

                        CategoryResDto res = CategoryResDto.builder()
                                .id(Long.toString((tmpChinese).get(i).getRestaurant_id()))
                                .name(tmpChinese.get(i).getName())
                                .currentTable(String.valueOf(tmpChinese.get(i).getCurrentTable()))
                                .totalTable(String.valueOf(tmpChinese.get(i).getTotalTable()))
                                .remainTime("10")
                                .lat(String.valueOf(tmpChinese.get(i).getLat()))
                                .lng(String.valueOf(tmpChinese.get(i).getLng()))
                                .phoneNumber(tmpChinese.get(i).getPhoneNumber())
                                .grade(ans)
                                .build();
                        return res;
                    }
                }
                break;
            case 2:
                List<JapaneseFood> tmpJapanese = japaneseFoodRepository.findAll();
                for(int i = 0; i < tmpJapanese.size(); i++){
                    if(tmpJapanese.get(i).getRestaurant_id() == id) {
                        double grade = 0;
                        int cnt = 0;
                        double ans = 0;
                        List<Reviews> tmpReview = reviewsRepository.findAll();
                        for(int a = 0; a < tmpReview.size(); a++){
                            if(tmpJapanese.get(i).getRestaurant_id() == tmpReview.get(a).getRestaurant_id()){
                                grade += tmpReview.get(a).getGrade();
                                cnt++;
                            }
                        }
                        ans = grade / cnt;

                        CategoryResDto res = CategoryResDto.builder()
                                .id(Long.toString((tmpJapanese).get(i).getRestaurant_id()))
                                .name(tmpJapanese.get(i).getName())
                                .currentTable(String.valueOf(tmpJapanese.get(i).getCurrentTable()))
                                .totalTable(String.valueOf(tmpJapanese.get(i).getTotalTable()))
                                .remainTime("10")
                                .lat(String.valueOf(tmpJapanese.get(i).getLat()))
                                .lng(String.valueOf(tmpJapanese.get(i).getLng()))
                                .phoneNumber(tmpJapanese.get(i).getPhoneNumber())
                                .grade(ans)
                                .build();
                        return res;
                    }
                }
                break;
            case 3:
                List<WesternFood> tmpWestern = westernFoodRepository.findAll();
                for(int i = 0; i < tmpWestern.size(); i++){
                    if(tmpWestern.get(i).getRestaurant_id() == id) {
                        double grade = 0;
                        int cnt = 0;
                        double ans = 0;
                        List<Reviews> tmpReview = reviewsRepository.findAll();
                        for(int a = 0; a < tmpReview.size(); a++){
                            if(tmpWestern.get(i).getRestaurant_id() == tmpReview.get(a).getRestaurant_id()){
                                grade += tmpReview.get(a).getGrade();
                                cnt++;
                            }
                        }
                        ans = grade / cnt;

                        CategoryResDto res = CategoryResDto.builder()
                                .id(Long.toString((tmpWestern).get(i).getRestaurant_id()))
                                .name(tmpWestern.get(i).getName())
                                .currentTable(String.valueOf(tmpWestern.get(i).getCurrentTable()))
                                .totalTable(String.valueOf(tmpWestern.get(i).getTotalTable()))
                                .remainTime("10")
                                .lat(String.valueOf(tmpWestern.get(i).getLat()))
                                .lng(String.valueOf(tmpWestern.get(i).getLng()))
                                .phoneNumber(tmpWestern.get(i).getPhoneNumber())
                                .grade(ans)
                                .build();
                        return res;
                    }
                }
                break;
            case 4:
                List<BoonsikFood> tmpBoonsik = boonsikFoodRepository.findAll();
                for(int i = 0; i < tmpBoonsik.size(); i++){
                    if(tmpBoonsik.get(i).getRestaurant_id() == id) {
                        double grade = 0;
                        int cnt = 0;
                        double ans = 0;
                        List<Reviews> tmpReview = reviewsRepository.findAll();
                        for(int a = 0; a < tmpReview.size(); a++){
                            if(tmpBoonsik.get(i).getRestaurant_id() == tmpReview.get(a).getRestaurant_id()){
                                grade += tmpReview.get(a).getGrade();
                                cnt++;
                            }
                        }
                        ans = grade / cnt;

                        CategoryResDto res = CategoryResDto.builder()
                                .id(Long.toString((tmpBoonsik).get(i).getRestaurant_id()))
                                .name(tmpBoonsik.get(i).getName())
                                .currentTable(String.valueOf(tmpBoonsik.get(i).getCurrentTable()))
                                .totalTable(String.valueOf(tmpBoonsik.get(i).getTotalTable()))
                                .remainTime("10")
                                .lat(String.valueOf(tmpBoonsik.get(i).getLat()))
                                .lng(String.valueOf(tmpBoonsik.get(i).getLng()))
                                .phoneNumber(tmpBoonsik.get(i).getPhoneNumber())
                                .grade(ans)
                                .build();
                        return res;
                    }
                }
                break;
            default:
                // 예외 확인
                CategoryResDto res = new CategoryResDto();
                res.setName("ohmygod");
                return res;
        }
        // 예외 확인
        CategoryResDto res = new CategoryResDto();
        res.setName("fail");

        return res;
    }

}
