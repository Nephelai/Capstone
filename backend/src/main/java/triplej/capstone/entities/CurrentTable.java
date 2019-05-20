package triplej.capstone.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CurrentTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(targetEntity = Restaurants.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurants_id")
    private long restaurant_id;

    @Column
    private Integer currentTable;
}
