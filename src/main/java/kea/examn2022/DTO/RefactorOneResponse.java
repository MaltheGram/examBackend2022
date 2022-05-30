package kea.examn2022.DTO;


import com.fasterxml.jackson.annotation.JsonInclude;
import kea.examn2022.Entity.RefactorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RefactorOneResponse {
    private Long id;
    private String RefactorFieldOne;
    private String RefactorFieldTwo;
    private String RefactorFieldThree;
    private Integer RefactorFieldFour;

    public RefactorOneResponse(RefactorEntity refactorEntity) {
        id = refactorEntity.getId();
        RefactorFieldOne = refactorEntity.getRefactorFieldOne();
        RefactorFieldTwo = refactorEntity.getRefactorFieldTwo();
        RefactorFieldThree = refactorEntity.getRefactorFieldThree();
        RefactorFieldFour = refactorEntity.getRefactorFieldFour();
    }

    public static List<RefactorOneResponse> convertFromEntity(List<RefactorEntity> refactors){
        return refactors.stream().map(refactor -> new RefactorOneResponse(refactor)).collect(Collectors.toList());
    }
}
