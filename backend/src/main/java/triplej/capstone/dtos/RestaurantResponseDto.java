package triplej.capstone.dtos;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class RestaurantResponseDto {
    private int rank;
    private String name;
    private int currentTable;
    private int totalTable;
    private int remainTime;
}
