package triplej.capstone.services;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import triplej.capstone.dtos.CurrentTableDto;
import triplej.capstone.dtos.RestaurantsTimeStampDto;
import triplej.capstone.entities.*;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@AllArgsConstructor
public class CurrentTableService {
    private BoonsikFoodRepository boonsikFoodRepository;
    private ChineseFoodRepository chineseFoodRepository;
    private JapaneseFoodRepository japaneseFoodRepository;
    private KoreanFoodRepository koreanFoodRepository;
    private WesternFoodRepository westernFoodRepository;

    private RestaurantsTimeStampRepository restaurantsTimeStampRepository;

    @Autowired
    private FindFirstTimeService findFirstTimeService;

    @Transactional
    public CurrentTableDto increment(int category_id, long id) {
        CurrentTableDto res = new CurrentTableDto();
        SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        int updateCurrent = 0;
        switch (category_id) {
            case 0:
                List<KoreanFood> tmpKorean = koreanFoodRepository.findAll();
                for(int i = 0; i < tmpKorean.size(); i++){
                    if(tmpKorean.get(i).getRestaurant_id() == id) {
                        if(tmpKorean.get(i).getCurrentTable() + 1 > tmpKorean.get(i).getTotalTable()){
                            return res;
                        }
                        updateCurrent = tmpKorean.get(i).getCurrentTable() + 1;
                        tmpKorean.get(i).setCurrentTable(updateCurrent);
                        koreanFoodRepository.save(tmpKorean.get(i));
                        restaurantsTimeStampRepository.save(RestaurantsTimeStamp.builder()
                            .restaurant_id(id)
                            .time(format.format(System.currentTimeMillis()))
                            .build()
                        );
                        res.setName(tmpKorean.get(i).getName());
                        res.setCurrentTable(tmpKorean.get(i).getCurrentTable());
                        res.setTotalTable(tmpKorean.get(i).getTotalTable());
                        break;
                    }
                }
                break;
            case 1:
                List<ChineseFood> tmpChinese = chineseFoodRepository.findAll();
                for(int i = 0; i < tmpChinese.size(); i++){
                    if(tmpChinese.get(i).getRestaurant_id() == id) {
                        if(tmpChinese.get(i).getCurrentTable() + 1 > tmpChinese.get(i).getTotalTable()){
                            return res;
                        }
                        updateCurrent = tmpChinese.get(i).getCurrentTable() + 1;
                        tmpChinese.get(i).setCurrentTable(updateCurrent);
                        chineseFoodRepository.save(tmpChinese.get(i));
                        restaurantsTimeStampRepository.save(RestaurantsTimeStamp.builder()
                                .restaurant_id(id)
                                .time(format.format(System.currentTimeMillis()))
                                .build()
                        );
                        res.setName(tmpChinese.get(i).getName());
                        res.setCurrentTable(tmpChinese.get(i).getCurrentTable());
                        res.setTotalTable(tmpChinese.get(i).getTotalTable());
                        break;
                    }
                }
                break;
            case 2:
                List<JapaneseFood> tmpJapanese = japaneseFoodRepository.findAll();
                for(int i = 0; i < tmpJapanese.size(); i++){
                    if(tmpJapanese.get(i).getRestaurant_id() == id) {
                        if(tmpJapanese.get(i).getCurrentTable() + 1 > tmpJapanese.get(i).getTotalTable()){
                            return res;
                        }
                        updateCurrent = tmpJapanese.get(i).getCurrentTable() + 1;
                        tmpJapanese.get(i).setCurrentTable(updateCurrent);
                        japaneseFoodRepository.save(tmpJapanese.get(i));
                        restaurantsTimeStampRepository.save(RestaurantsTimeStamp.builder()
                                .restaurant_id(id)
                                .time(format.format(System.currentTimeMillis()))
                                .build()
                        );
                        res.setName(tmpJapanese.get(i).getName());
                        res.setCurrentTable(tmpJapanese.get(i).getCurrentTable());
                        res.setTotalTable(tmpJapanese.get(i).getTotalTable());
                        break;
                    }
                }
                break;
            case 3:
                List<WesternFood> tmpWestern = westernFoodRepository.findAll();
                for(int i = 0; i < tmpWestern.size(); i++){
                    if(tmpWestern.get(i).getRestaurant_id() == id) {
                        if(tmpWestern.get(i).getCurrentTable() + 1 > tmpWestern.get(i).getTotalTable()){
                            return res;
                        }
                        updateCurrent = tmpWestern.get(i).getCurrentTable() + 1;
                        tmpWestern.get(i).setCurrentTable(updateCurrent);
                        westernFoodRepository.save(tmpWestern.get(i));
                        restaurantsTimeStampRepository.save(RestaurantsTimeStamp.builder()
                                .restaurant_id(id)
                                .time(format.format(System.currentTimeMillis()))
                                .build()
                        );
                        res.setName(tmpWestern.get(i).getName());
                        res.setCurrentTable(tmpWestern.get(i).getCurrentTable());
                        res.setTotalTable(tmpWestern.get(i).getTotalTable());
                        break;
                    }
                }
                break;
            case 4:
                List<BoonsikFood> tmpBoonsik = boonsikFoodRepository.findAll();
                for(int i = 0; i < tmpBoonsik.size(); i++){
                    if(tmpBoonsik.get(i).getRestaurant_id() == id) {
                        if(tmpBoonsik.get(i).getCurrentTable() + 1 > tmpBoonsik.get(i).getTotalTable()){
                            return res;
                        }
                        updateCurrent = tmpBoonsik.get(i).getCurrentTable() + 1;
                        tmpBoonsik.get(i).setCurrentTable(updateCurrent);
                        boonsikFoodRepository.save(tmpBoonsik.get(i));
                        restaurantsTimeStampRepository.save(RestaurantsTimeStamp.builder()
                                .restaurant_id(id)
                                .time(format.format(System.currentTimeMillis()))
                                .build()
                        );
                        res.setName(tmpBoonsik.get(i).getName());
                        res.setCurrentTable(tmpBoonsik.get(i).getCurrentTable());
                        res.setTotalTable(tmpBoonsik.get(i).getTotalTable());
                        break;
                    }
                }
                break;
            default:
                break;
        }

        return res;
    }

    @Transactional
    public CurrentTableDto decrement(int category_id, long id) {
        CurrentTableDto res = new CurrentTableDto();

        int updateCurrent = 0;
        switch (category_id) {
            case 0:
                List<KoreanFood> tmpKorean = koreanFoodRepository.findAll();
                for(int i = 0; i < tmpKorean.size(); i++){
                    if(tmpKorean.get(i).getRestaurant_id() == id) {
                        if(tmpKorean.get(i).getCurrentTable() - 1 < 0) {
                            return res;
                        }
                        updateCurrent = tmpKorean.get(i).getCurrentTable() - 1;
                        tmpKorean.get(i).setCurrentTable(updateCurrent);
                        koreanFoodRepository.save(tmpKorean.get(i));
                        restaurantsTimeStampRepository.deleteById(findFirstTimeService.findFirstTime(Long.toString(id)));
                        res.setName(tmpKorean.get(i).getName());
                        res.setCurrentTable(tmpKorean.get(i).getCurrentTable());
                        res.setTotalTable(tmpKorean.get(i).getTotalTable());
                        break;
                    }
                }

                break;
            case 1:
                List<ChineseFood> tmpChinese = chineseFoodRepository.findAll();
                for(int i = 0; i < tmpChinese.size(); i++){
                    if(tmpChinese.get(i).getRestaurant_id() == id) {
                        if(tmpChinese.get(i).getCurrentTable() - 1 < 0) {
                            return res;
                        }
                        updateCurrent = tmpChinese.get(i).getCurrentTable() - 1;
                        tmpChinese.get(i).setCurrentTable(updateCurrent);
                        chineseFoodRepository.save(tmpChinese.get(i));
                        restaurantsTimeStampRepository.deleteById(findFirstTimeService.findFirstTime(Long.toString(id)));
                        res.setName(tmpChinese.get(i).getName());
                        res.setCurrentTable(tmpChinese.get(i).getCurrentTable());
                        res.setTotalTable(tmpChinese.get(i).getTotalTable());
                        break;
                    }
                }
                break;
            case 2:
                List<JapaneseFood> tmpJapanese = japaneseFoodRepository.findAll();
                for(int i = 0; i < tmpJapanese.size(); i++){
                    if(tmpJapanese.get(i).getRestaurant_id() == id) {
                        if(tmpJapanese.get(i).getCurrentTable() - 1 < 0) {
                            return res;
                        }
                        updateCurrent = tmpJapanese.get(i).getCurrentTable() - 1;
                        tmpJapanese.get(i).setCurrentTable(updateCurrent);
                        japaneseFoodRepository.save(tmpJapanese.get(i));
                        restaurantsTimeStampRepository.deleteById(findFirstTimeService.findFirstTime(Long.toString(id)));
                        res.setName(tmpJapanese.get(i).getName());
                        res.setCurrentTable(tmpJapanese.get(i).getCurrentTable());
                        res.setTotalTable(tmpJapanese.get(i).getTotalTable());
                        break;
                    }
                }
                break;
            case 3:
                List<WesternFood> tmpWestern = westernFoodRepository.findAll();
                for(int i = 0; i < tmpWestern.size(); i++){
                    if(tmpWestern.get(i).getRestaurant_id() == id) {
                        if(tmpWestern.get(i).getCurrentTable() - 1 < 0) {
                            return res;
                        }
                        updateCurrent = tmpWestern.get(i).getCurrentTable() - 1;
                        tmpWestern.get(i).setCurrentTable(updateCurrent);
                        westernFoodRepository.save(tmpWestern.get(i));
                        restaurantsTimeStampRepository.deleteById(findFirstTimeService.findFirstTime(Long.toString(id)));
                        res.setName(tmpWestern.get(i).getName());
                        res.setCurrentTable(tmpWestern.get(i).getCurrentTable());
                        res.setTotalTable(tmpWestern.get(i).getTotalTable());
                        break;
                    }
                }
                break;
            case 4:
                List<BoonsikFood> tmpBoonsik = boonsikFoodRepository.findAll();
                for(int i = 0; i < tmpBoonsik.size(); i++){
                    if(tmpBoonsik.get(i).getRestaurant_id() == id) {
                        if(tmpBoonsik.get(i).getCurrentTable() - 1 < 0) {
                            return res;
                        }
                        updateCurrent = tmpBoonsik.get(i).getCurrentTable() - 1;
                        tmpBoonsik.get(i).setCurrentTable(updateCurrent);
                        boonsikFoodRepository.save(tmpBoonsik.get(i));
                        restaurantsTimeStampRepository.deleteById(findFirstTimeService.findFirstTime(Long.toString(id)));
                        res.setName(tmpBoonsik.get(i).getName());
                        res.setCurrentTable(tmpBoonsik.get(i).getCurrentTable());
                        res.setTotalTable(tmpBoonsik.get(i).getTotalTable());
                        break;
                    }
                }
                break;
            default:
                break;
        }

        return res;
    }

}
