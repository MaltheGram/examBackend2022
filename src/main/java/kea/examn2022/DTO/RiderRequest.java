package kea.examn2022.DTO;


import kea.examn2022.Entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RiderRequest {
    private Long id;
    private String totalTime;
    private Integer sprintPoint;
    private Integer mountainPoint;
    private String riderName;
    private Integer age;
    // Gives the Team entity as a part of the request body
    //private TeamRequest team;
}
