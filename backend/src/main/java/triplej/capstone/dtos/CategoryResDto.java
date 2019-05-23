package triplej.capstone.dtos;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResDto {
    private String rank;
    private String name;
    private String currentTable;
    private String totalTable;
    private String remainTime;
    private String lat;
    private String lng;
}
