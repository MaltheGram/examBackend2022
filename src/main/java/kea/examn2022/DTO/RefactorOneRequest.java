package kea.examn2022.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefactorOneRequest {
    private Long id;
    private String RefactorFieldOne;
    private String RefactorFieldTwo;
    private String RefactorFieldThree;
    private Integer RefactorFieldFour;
}
