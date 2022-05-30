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
    private Integer totalTime;
    private Integer sprintPoint;
    private Integer mountainPoint;
    private String riderName;
    private Integer age;
    private Team team;
}
