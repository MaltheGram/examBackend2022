package kea.examn2022.api;

import kea.examn2022.DTO.RiderRequest;
import kea.examn2022.DTO.RiderResponse;
import kea.examn2022.DTO.TeamRequest;
import kea.examn2022.DTO.TeamResponse;
import kea.examn2022.Service.RiderService;
import kea.examn2022.Service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/teams")
public class TeamController {
    TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/{id}")
    public TeamResponse getSingleTeam(@PathVariable Long id) {
        return teamService.getTeam(id);
    }

    @GetMapping()
    public List<TeamResponse> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping()
    public void addTeam(@RequestBody TeamRequest team) {
        teamService.addTeam(team);
    }

    @PutMapping("/{id}")
    public TeamResponse updateTeam(@PathVariable Long id, @RequestBody TeamRequest team) {
        return teamService.updateTeam(id, team);
    }
    @DeleteMapping("/{id}")
    public void updateTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }

}
