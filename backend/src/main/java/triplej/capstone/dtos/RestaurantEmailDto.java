package triplej.capstone.dtos;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantEmailDto {
    private String id;
    private String email;
}
