package kea.examn2022.DTO;

import kea.examn2022.Entity.Rider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequest {
    private Long id;
    //private Set<Rider> riderList;
    private String teamName;


}
