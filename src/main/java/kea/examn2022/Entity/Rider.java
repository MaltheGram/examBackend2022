package kea.examn2022.Entity;


import kea.examn2022.DTO.RiderRequest;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;

@Entity(name = "Rider")
@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private LocalTime totalTime;
    private Integer sprintPoint;
    private Integer mountainPoint;
    private String riderName;
    private Integer age;

    @ManyToOne
    private Team team;


    public Rider(LocalTime totalTime, Integer sprintPoint, Integer mountainPoint, String riderName, Integer age) {
        this.totalTime = totalTime;
        this.sprintPoint = sprintPoint;
        this.mountainPoint = mountainPoint;
        this.riderName = riderName;
        this.age = age;
    }

    public Rider(String riderName) {
        this.riderName = riderName;
    }
}
