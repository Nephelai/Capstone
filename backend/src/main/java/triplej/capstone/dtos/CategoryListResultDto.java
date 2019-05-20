package triplej.capstone.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import triplej.capstone.entities.ChineseFood;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class CategoryListResultDto {
    private String id;
    private String restaurantId;
    private String name;
    private String phoneNumber;
    private String totalTable;
    private String currentTable;

    public CategoryListResultDto(ChineseFood entity) {
        this.id = String.valueOf(entity.getId());


    }
}
