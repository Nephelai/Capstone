package triplej.capstone.dtos;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrentTableDto {
    private String name;
    private int currentTable;
    private int totalTable;
}
