package triplej.capstone.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long restaurant_id;

    @Column
    private String user_id;

    @Column
    private String user_pw;

    @Column
    private String comment;

    @Column
    private double grade;

    @Column
    private String time;

}
