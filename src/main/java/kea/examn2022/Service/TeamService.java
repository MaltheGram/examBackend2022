package kea.examn2022.Service;

import kea.examn2022.DTO.TeamRequest;
import kea.examn2022.DTO.TeamResponse;
import kea.examn2022.Entity.Team;
import kea.examn2022.Repository.RiderRepository;
import kea.examn2022.Repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    public TeamResponse addTeam(TeamRequest team) {
        Team teamToAdd = new Team(team.getTeamName());
        teamRepository.save(teamToAdd);

        return new TeamResponse(teamToAdd);
    }

    public TeamResponse updateTeam(Long id, TeamRequest team) {
        Team t = teamRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Team with given id not found"));
        t.setTeamName(team.getTeamName());

        teamRepository.save(t);
        return new TeamResponse(t);
    }

    public void deleteTeam(Long id) {
        riderRepository.deleteById(id);
    }
}


