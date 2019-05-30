package triplej.capstone.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import triplej.capstone.dtos.CategoryResDto;
import triplej.capstone.dtos.CurrentTableDto;
import triplej.capstone.dtos.RestaurantResponseDto;
import triplej.capstone.entities.*;

import java.util.List;

@Service
@AllArgsConstructor
public class CurrentTableService {
    private BoonsikFoodRepository boonsikFoodRepository;
    private ChineseFoodRepository chineseFoodRepository;
    private JapaneseFoodRepository japaneseFoodRepository;
    private KoreanFoodRepository koreanFoodRepository;
    private WesternFoodRepository westernFoodRepository;

    @Transactional(readOnly = true)
    public CurrentTableDto increment(int category_id, int id) {
        CurrentTableDto res = new CurrentTableDto();

        int updateCurrent = 0;
        switch (category_id) {
            case 0:
                List<KoreanFood> tmpKorean = koreanFoodRepository.findAll();
                for(int i = 0; i < tmpKorean.size(); i++){
                    if(tmpKorean.get(i).getId() == id) {
                        updateCurrent = tmpKorean.get(i).getCurrentTable() + 1;
                        tmpKorean.get(i).setCurrentTable(updateCurrent);
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
                    if(tmpChinese.get(i).getId() == id) {
                        updateCurrent = tmpChinese.get(i).getCurrentTable() + 1;
                        tmpChinese.get(i).setCurrentTable(updateCurrent);
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
                    if(tmpJapanese.get(i).getId() == id) {
                        updateCurrent = tmpJapanese.get(i).getCurrentTable() + 1;
                        tmpJapanese.get(i).setCurrentTable(updateCurrent);
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
                    if(tmpWestern.get(i).getId() == id) {
                        updateCurrent = tmpWestern.get(i).getCurrentTable() + 1;
                        tmpWestern.get(i).setCurrentTable(updateCurrent);
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
                    if(tmpBoonsik.get(i).getId() == id) {
                        updateCurrent = tmpBoonsik.get(i).getCurrentTable() + 1;
                        tmpBoonsik.get(i).setCurrentTable(updateCurrent);
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

    @Transactional(readOnly = true)
    public CurrentTableDto decrement(int category_id, int id) {
        CurrentTableDto res = new CurrentTableDto();

        int updateCurrent = 0;
        switch (category_id) {
            case 0:
                List<KoreanFood> tmpKorean = koreanFoodRepository.findAll();
                for(int i = 0; i < tmpKorean.size(); i++){
                    if(tmpKorean.get(i).getId() == id) {
                        updateCurrent = tmpKorean.get(i).getCurrentTable() - 1;
                        tmpKorean.get(i).setCurrentTable(updateCurrent);
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
                    if(tmpChinese.get(i).getId() == id) {
                        updateCurrent = tmpChinese.get(i).getCurrentTable() - 1;
                        tmpChinese.get(i).setCurrentTable(updateCurrent);
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
                    if(tmpJapanese.get(i).getId() == id) {
                        updateCurrent = tmpJapanese.get(i).getCurrentTable() - 1;
                        tmpJapanese.get(i).setCurrentTable(updateCurrent);
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
                    if(tmpWestern.get(i).getId() == id) {
                        updateCurrent = tmpWestern.get(i).getCurrentTable() - 1;
                        tmpWestern.get(i).setCurrentTable(updateCurrent);
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
                    if(tmpBoonsik.get(i).getId() == id) {
                        updateCurrent = tmpBoonsik.get(i).getCurrentTable() - 1;
                        tmpBoonsik.get(i).setCurrentTable(updateCurrent);
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
