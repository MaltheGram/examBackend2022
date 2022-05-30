package kea.examn2022.DTO;


import com.fasterxml.jackson.annotation.JsonInclude;
import kea.examn2022.Entity.Rider;
import kea.examn2022.Entity.Team;
import kea.examn2022.Service.DurationFormatter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter @Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RiderResponse {
    private Long id;
    private Integer totalTime;
    private Integer sprintPoint;
    private Integer mountainPoint;
    private String riderName;
    private Integer age;
    private TeamResponse teamResponse;


    public RiderResponse(Rider rider) {
        this.id = rider.getId();
        this.totalTime = rider.getTotalTime();
        this.sprintPoint = rider.getSprintPoint();
        this.mountainPoint = rider.getMountainPoint();
        this.riderName = rider.getRiderName();
        this.age = rider.getAge();
        this.teamResponse = new TeamResponse(rider.getTeam().getTeamName(), rider.getTeam().getId());
    }

    public static List<RiderResponse> convertFromEntity(List<Rider> riders){
        return riders.stream().map(rider -> new RiderResponse(rider)).collect(Collectors.toList());
    }
}
