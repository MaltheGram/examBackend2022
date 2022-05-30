package kea.examn2022.DTO;

import kea.examn2022.Entity.Rider;
import kea.examn2022.Entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponse {
    private Long id;
    private String teamName;
    // private Set<Rider> riders = new HashSet<>();
    // private RiderResponse riderResponse;


    public TeamResponse(Team team) {
        this.id = team.getId();
        this.teamName = team.getTeamName();
    }

    public TeamResponse(String teamName, Long id) {
        this.teamName = teamName;
        this.id = id;

    }

    public static List<TeamResponse> convertFromEntity(List<Team> teams){
        return teams.stream().map(team -> new TeamResponse(team)).collect(Collectors.toList());
    }
}
