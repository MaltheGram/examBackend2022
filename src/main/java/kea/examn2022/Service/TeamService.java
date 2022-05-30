package kea.examn2022.Service;

import kea.examn2022.DTO.RiderRequest;
import kea.examn2022.DTO.TeamRequest;
import kea.examn2022.DTO.TeamResponse;
import kea.examn2022.Entity.Rider;
import kea.examn2022.Entity.Team;
import kea.examn2022.Repository.RiderRepository;
import kea.examn2022.Repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TeamService {

    RiderRepository riderRepository;

    TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository, RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
        this.teamRepository = teamRepository;
    }

    public TeamResponse getTeam(Long id) {
        return new TeamResponse(teamRepository.findById(id).orElseThrow(RuntimeException::new));
    }


    public List<TeamResponse> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return TeamResponse.convertFromEntity(teams);
    }

    public void addTeam(TeamRequest team) {
        Team t = teamRepository.findById(team.getId()).orElseThrow(()-> new RuntimeException());
        t.setTeamName(t.getTeamName());
        teamRepository.save(t);
    }

    public TeamResponse updateTeam(Long id, TeamRequest team) {
        Team t = teamRepository.findById(id).orElseThrow(()-> new RuntimeException());
        team.setTeamName(team.getTeamName());
        t = teamRepository.save(t);
        return new TeamResponse(t);
    }

    public void deleteTeam(Long id) {
        riderRepository.deleteById(id);
    }
}


