package triplej.capstone.entities;

import lombok.AccessLevel;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // working .identity in mysql
    private long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 11, nullable = false)
    private String phoneNumber;

    private int totalTable;

    @Builder
    public Restaurants(String name, String phoneNumber, int totalTable) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.totalTable = totalTable;
    }
}
