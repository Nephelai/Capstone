package triplej.capstone.services;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import triplej.capstone.dtos.CategoryResDto;
import triplej.capstone.entities.*;

import java.text.SimpleDateFormat;
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
    private ReviewsRepository reviewsRepository;

    RestaurantListService restaurantListService;

    FindFirstTimeService findFirstTimeService;

    @Transactional(readOnly = true)
    public List<CategoryResDto> findRestaurantInCategory(int category_id) {
        List<CategoryResDto> resCategory = new ArrayList<CategoryResDto>();
        SimpleDateFormat format = new SimpleDateFormat ( "mm:ss");
        switch (category_id) {
            case 0:
                List<KoreanFood> tmpKorean = koreanFoodRepository.findAll();
                for(int i = 0; i < tmpKorean.size(); i++){
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
                    if(cnt == 0){
                        ans = 0;
                    }
                    else{
                        ans = grade / cnt;
                    }

                    CategoryResDto tmp = CategoryResDto.builder()
                            .id(Long.toString((tmpKorean).get(i).getRestaurant_id()))
                            .name(tmpKorean.get(i).getName())
                            .currentTable(String.valueOf(tmpKorean.get(i).getCurrentTable()))
                            .totalTable(String.valueOf(tmpKorean.get(i).getTotalTable()))
                            .remainTime("0")
                            .lat(String.valueOf(tmpKorean.get(i).getLat()))
                            .lng(String.valueOf(tmpKorean.get(i).getLng()))
                            .phoneNumber(tmpKorean.get(i).getPhoneNumber())
                            .grade(ans)
                            .cutLine(tmpKorean.get(i).getCutLine())
                            .build();
                    if(tmp.getCurrentTable().equals(tmp.getTotalTable())) {
                        Long tmpTime = System.currentTimeMillis() - findFirstTimeService.getFirstTime(tmp.getId());
                        tmpTime = tmp.getCutLine() - tmpTime;
                        if (tmpTime.compareTo(Long.valueOf(5 * 1000 * 60)) == -1) tmpTime = Long.valueOf(5 * 1000 * 60);
                        tmp.setRemainTime(format.format(tmpTime));
                    }

                    resCategory.add(tmp);
                }
                break;
            case 1:
                List<ChineseFood> tmpChinese = chineseFoodRepository.findAll();
                for(int i = 0; i < tmpChinese.size(); i++){
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
                    if(cnt == 0){
                        ans = 0;
                    }
                    else{
                        ans = grade / cnt;
                    }

                    CategoryResDto tmp = CategoryResDto.builder()
                            .id(Long.toString((tmpChinese).get(i).getRestaurant_id()))
                            .name(tmpChinese.get(i).getName())
                            .currentTable(String.valueOf(tmpChinese.get(i).getCurrentTable()))
                            .totalTable(String.valueOf(tmpChinese.get(i).getTotalTable()))
                            .remainTime("0")
                            .lat(String.valueOf(tmpChinese.get(i).getLat()))
                            .lng(String.valueOf(tmpChinese.get(i).getLng()))
                            .phoneNumber(tmpChinese.get(i).getPhoneNumber())
                            .grade(ans)
                            .cutLine(tmpChinese.get(i).getCutLine())
                            .build();
                    if(tmp.getCurrentTable().equals(tmp.getTotalTable())) {
                        Long tmpTime = System.currentTimeMillis() - findFirstTimeService.getFirstTime(tmp.getId());
                        tmpTime = tmp.getCutLine() - tmpTime;
                        if (tmpTime.compareTo(Long.valueOf(5 * 1000 * 60)) == -1) tmpTime = Long.valueOf(5 * 1000 * 60);
                        tmp.setRemainTime(format.format(tmpTime));
                    }

                    resCategory.add(tmp);
                }
                break;
            case 2:
                List<JapaneseFood> tmpJapanese = japaneseFoodRepository.findAll();
                for(int i = 0; i < tmpJapanese.size(); i++){
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
                    if(cnt == 0){
                        ans = 0;
                    }
                    else{
                        ans = grade / cnt;
                    }

                    CategoryResDto tmp = CategoryResDto.builder()
                            .id(Long.toString((tmpJapanese).get(i).getRestaurant_id()))
                            .name(tmpJapanese.get(i).getName())
                            .currentTable(String.valueOf(tmpJapanese.get(i).getCurrentTable()))
                            .totalTable(String.valueOf(tmpJapanese.get(i).getTotalTable()))
                            .remainTime("0")
                            .lat(String.valueOf(tmpJapanese.get(i).getLat()))
                            .lng(String.valueOf(tmpJapanese.get(i).getLng()))
                            .phoneNumber(tmpJapanese.get(i).getPhoneNumber())
                            .grade(ans)
                            .cutLine(tmpJapanese.get(i).getCutLine())
                            .build();
                    if(tmp.getCurrentTable().equals(tmp.getTotalTable())) {
                        Long tmpTime = System.currentTimeMillis() - findFirstTimeService.getFirstTime(tmp.getId());
                        tmpTime = tmp.getCutLine() - tmpTime;
                        if (tmpTime.compareTo(Long.valueOf(5 * 1000 * 60)) == -1) tmpTime = Long.valueOf(5 * 1000 * 60);
                        tmp.setRemainTime(format.format(tmpTime));
                    }
                    resCategory.add(tmp);
                }
                break;
            case 3:
                List<WesternFood> tmpWestern = westernFoodRepository.findAll();
                for(int i = 0; i < tmpWestern.size(); i++){
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
                    if(cnt == 0){
                        ans = 0;
                    }
                    else{
                        ans = grade / cnt;
                    }

                    CategoryResDto tmp = CategoryResDto.builder()
                            .id(Long.toString((tmpWestern).get(i).getRestaurant_id()))
                            .name(tmpWestern.get(i).getName())
                            .currentTable(String.valueOf(tmpWestern.get(i).getCurrentTable()))
                            .totalTable(String.valueOf(tmpWestern.get(i).getTotalTable()))
                            .remainTime("0")
                            .lat(String.valueOf(tmpWestern.get(i).getLat()))
                            .lng(String.valueOf(tmpWestern.get(i).getLng()))
                            .phoneNumber(tmpWestern.get(i).getPhoneNumber())
                            .grade(ans)
                            .cutLine(tmpWestern.get(i).getCutLine())
                            .build();
                    if(tmp.getCurrentTable().equals(tmp.getTotalTable())) {
                        Long tmpTime = System.currentTimeMillis() - findFirstTimeService.getFirstTime(tmp.getId());
                        tmpTime = tmp.getCutLine() - tmpTime;
                        if (tmpTime.compareTo(Long.valueOf(5 * 1000 * 60)) == -1) tmpTime = Long.valueOf(5 * 1000 * 60);
                        tmp.setRemainTime(format.format(tmpTime));
                    }
                    resCategory.add(tmp);
                }
                break;
            case 4:
                List<BoonsikFood> tmpBoonsik = boonsikFoodRepository.findAll();
                for(int i = 0; i < tmpBoonsik.size(); i++){
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
                    if(cnt == 0){
                        ans = 0;
                    }
                    else{
                        ans = grade / cnt;
                    }

                    CategoryResDto tmp = CategoryResDto.builder()
                            .id(Long.toString((tmpBoonsik).get(i).getRestaurant_id()))
                            .name(tmpBoonsik.get(i).getName())
                            .currentTable(String.valueOf(tmpBoonsik.get(i).getCurrentTable()))
                            .totalTable(String.valueOf(tmpBoonsik.get(i).getTotalTable()))
                            .remainTime("0")
                            .lat(String.valueOf(tmpBoonsik.get(i).getLat()))
                            .lng(String.valueOf(tmpBoonsik.get(i).getLng()))
                            .phoneNumber(tmpBoonsik.get(i).getPhoneNumber())
                            .grade(grade)
                            .cutLine(tmpBoonsik.get(i).getCutLine())
                            .build();
                    if(tmp.getCurrentTable().equals(tmp.getTotalTable())) {
                        Long tmpTime = System.currentTimeMillis() - findFirstTimeService.getFirstTime(tmp.getId());
                        tmpTime = tmp.getCutLine() - tmpTime;
                        if (tmpTime.compareTo(Long.valueOf(5 * 1000 * 60)) == -1) tmpTime = Long.valueOf(5 * 1000 * 60);
                        tmp.setRemainTime(format.format(tmpTime));
                    }
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
