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
<<<<<<< HEAD
    @OneToOne(targetEntity = Restaurants.class)
=======
    @OneToOne(targetEntity = Restaurants.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
>>>>>>> 0aa7e60c7d7d91f25169e2aa27b51db2543e0c45
=======
    @OneToOne(targetEntity = Restaurants.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
>>>>>>> Sample Data Insert
    @JoinColumn(name = "restaurants_id")
    private long restaurant_id;

    @Column
    private Integer currentTable;
}
