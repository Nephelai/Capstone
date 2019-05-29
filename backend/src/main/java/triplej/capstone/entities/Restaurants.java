package triplej.capstone.entities;

import lombok.AccessLevel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter // get 함수 생성
@Setter
@Entity // Entity를 만드는 과정을 Annotation으로 해결
public class Restaurants implements Serializable {
    // Entity 생성 PK 설정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // working .identity in mysql
    @JoinColumn(name = "restaurant_id")
    private long id;

    @Column(length = 12, nullable = false)
    private String category;

    // 생성자
    @Builder
    public Restaurants(String category) {
        this.category = category;
    }
}
