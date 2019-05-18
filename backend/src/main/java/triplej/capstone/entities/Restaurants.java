package triplej.capstone.entities;

import lombok.AccessLevel;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter // get 함수 생성
@Entity // Entity를 만드는 과정을 Annotation으로 해결
public class Restaurants {
    // Entity 생성 PK 설정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // working .identity in mysql
    private long id;

    // Column 구성
    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 11, nullable = false)
    private String phoneNumber;

    private int currentTable;
    private int totalTable;

    // 생성자
    @Builder
    public Restaurants(String name, String phoneNumber,int currentTable, int totalTable) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.currentTable = currentTable;
        this.totalTable = totalTable;
    }
}
