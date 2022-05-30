package kea.examn2022.Entity;


import kea.examn2022.DTO.RefactorOneRequest;
import lombok.*;

import javax.persistence.*;

@Table(name = "ENTITYONE")
@Entity(name = "refactorEntityOne")
@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefactorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String RefactorFieldOne;
    private String RefactorFieldTwo;
    private String RefactorFieldThree;
    private Integer RefactorFieldFour;

    public RefactorEntity(String refactorFieldOne, String refactorFieldTwo, String refactorFieldThree, Integer refactorFieldFour) {
        RefactorFieldOne = refactorFieldOne;
        RefactorFieldTwo = refactorFieldTwo;
        RefactorFieldThree = refactorFieldThree;
        RefactorFieldFour = refactorFieldFour;
    }

    public RefactorEntity(RefactorOneRequest request){
        this.RefactorFieldOne = request.getRefactorFieldOne();
        this.RefactorFieldTwo = request.getRefactorFieldTwo();
        this.RefactorFieldThree = request.getRefactorFieldThree();
        this.RefactorFieldFour = request.getRefactorFieldFour();
    }
}
