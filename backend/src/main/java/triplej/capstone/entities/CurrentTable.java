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

<<<<<<< HEAD
    @OneToOne(targetEntity = Restaurants.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
=======
    @OneToOne(targetEntity = Restaurants.class)
    @JoinColumn(name = "restaurants_id")
>>>>>>> Make DB Table
    private long restaurant_id;

    @Column
    private Integer currentTable;
}
