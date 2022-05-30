package kea.examn2022.Service;

import kea.examn2022.DTO.RiderRequest;
import kea.examn2022.DTO.RiderResponse;
import kea.examn2022.Entity.Rider;
import kea.examn2022.Entity.Team;
import kea.examn2022.Error.Exception40x;
import kea.examn2022.Repository.RiderRepository;
import kea.examn2022.Repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RiderService {
    RiderRepository riderRepository;
    TeamRepository teamRepository;

    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    public List<RiderResponse> getAllRiders(String team) {

        if(team != null) {
            return riderRepository.findRidersByTeam_TeamName(team).stream().map(RiderResponse::new).collect(Collectors.toList());
        } else {
            return riderRepository.findAll().stream().map(RiderResponse::new).collect(Collectors.toList());
        }
    }

    public RiderResponse getSingleRider(Long id) {
        Rider rider = riderRepository.findById(id).orElseThrow( () -> new Exception40x("Not a valid search"));

        return new RiderResponse(rider);
    }

    public void addRider(RiderRequest rider) {
        Rider r = new Rider(rider.getRiderName());
        Team t = teamRepository.findById(rider.getTeam().getId()).orElseThrow(()-> new RuntimeException());
        r.setTeam(t);
        riderRepository.save(r);
    }

    public RiderResponse updateRider(Long id, RiderRequest rider) {
        Rider r = riderRepository.findById(id).orElseThrow(()-> new RuntimeException());
        r.setRiderName(r.getRiderName());
        r = riderRepository.save(r);
        return new RiderResponse(r);
    }

    public void deleteRider(Long id) {
        riderRepository.deleteById(id);
    }



}
