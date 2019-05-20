package triplej.capstone.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter // get 함수 생성
@Entity
public class WesternFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(targetEntity = Restaurants.class)
    @JoinColumn(name = "restaurants_id")
    private long restaurant_id;

    // Column 구성
    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 11, nullable = false)
    private String phoneNumber;

    @Column
    private int totalTable;
}
