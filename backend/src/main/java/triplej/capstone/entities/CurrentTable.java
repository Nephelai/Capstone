package triplej.capstone.entities;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(Restaurants.class)
public class CurrentTable {
    @Id
    @Column(name = "restaurants_id")
    private long id;
}
