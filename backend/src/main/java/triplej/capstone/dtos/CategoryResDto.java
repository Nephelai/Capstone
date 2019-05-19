package triplej.capstone.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class CategoryResDto {
    private String rank;
    private String name;
    private String currentTable;
    private String totalTable;
    private String remainTime;
}
