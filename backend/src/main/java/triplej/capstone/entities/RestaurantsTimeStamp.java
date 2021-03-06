package triplej.capstone.entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class RestaurantsTimeStamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long restaurant_id;

    @Column
    private long time;

    @Builder
    public RestaurantsTimeStamp(Long restaurant_id, long time) {
        this.restaurant_id = restaurant_id;
        this.time = time;
    }
}
