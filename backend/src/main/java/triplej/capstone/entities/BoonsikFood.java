package triplej.capstone.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class BoonsikFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "restaurant_id")
    private long restaurant_id;

    // Column 구성
    @Column(length = 50, nullable = false)
    private String name;

    @Column
    private String phoneNumber;

    @Column
    private int currentTable;

    @Column
    private int totalTable;

    @Column
    private double lat;

    @Column
    private double lng;
}
