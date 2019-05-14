package triplej.capstone.dtos;
import lombok.Getter;

@Getter
public class RestaurantResponseDto {
    private String name;
    private int currentTable;
    private int totalTable;

}
