package triplej.capstone.dtos;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResDto {
    private long restaurant_id;
    private String user_id;
    private String user_pw;
    private String comment;
    private double grade;
    private String time;
}
