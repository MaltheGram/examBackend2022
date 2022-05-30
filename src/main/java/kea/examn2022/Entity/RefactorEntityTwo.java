package kea.examn2022.Entity;


import lombok.*;

import javax.persistence.*;

@Table(name = "ENTITYTWO")
@Entity(name = "refactorEntityTwo")
@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefactorEntityTwo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String RefactorFieldOne;
    private String RefactorFieldTwo;
    private String RefactorFieldThree;
    private Integer RefactorFieldFour;

    public RefactorEntityTwo(String refactorFieldOne, String refactorFieldTwo, String refactorFieldThree, Integer refactorFieldFour) {
        RefactorFieldOne = refactorFieldOne;
        RefactorFieldTwo = refactorFieldTwo;
        RefactorFieldThree = refactorFieldThree;
        RefactorFieldFour = refactorFieldFour;
    }
}
