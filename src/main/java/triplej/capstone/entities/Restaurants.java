package triplej.capstone.entities;

import lombok.AccessLevel;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Restaurants {
    @Id
    @GeneratedValue
    private long id;

    @Column()
    private String name;

    @Column()
    private String phoneNumber;

    @Column()
    private int totalTable;
}
