package kea.examn2022.Service;

import kea.examn2022.DTO.RiderRequest;
import kea.examn2022.DTO.RiderResponse;
import kea.examn2022.Entity.Rider;
import kea.examn2022.Error.Exception40x;
import kea.examn2022.Repository.RiderRepository;
import kea.examn2022.Repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<RiderResponse> getAllRiders() {
        return riderRepository.findAll().stream().map(RiderResponse::new).collect(Collectors.toList());
    }

    public RiderResponse getSingleRider(Long id) {
        Rider rider = riderRepository.findById(id).orElseThrow( () -> new Exception40x("Not a valid search"));

        return new RiderResponse(rider);
    }

    public void addRider(RiderRequest rider) {
        Rider r = new Rider(rider.getRiderName());
        r.setRiderName(rider.getRiderName());
        r.setTotalTime(rider.getTotalTime());
        r.setSprintPoint(rider.getSprintPoint());
        r.setMountainPoint(rider.getMountainPoint());
        r.setAge(rider.getAge());
        riderRepository.save(r);
    }

    public RiderResponse updateRider(RiderRequest rider, Long id) {
        Rider riderToEdit = riderRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Rider with provided id not found"));
        riderToEdit.setRiderName(rider.getRiderName());
        riderToEdit.setAge(rider.getAge());
        riderToEdit.setSprintPoint(rider.getSprintPoint());
        riderToEdit.setMountainPoint(rider.getMountainPoint());
        riderToEdit.setTotalTime(rider.getTotalTime());

        Rider r = riderRepository.save(riderToEdit);
        return new RiderResponse(r);
    }

    public void deleteRider(Long id) {
        riderRepository.deleteById(id);
    }

    public RiderResponse getWinner(String color) {

        List<RiderResponse> allRiders = getAllRiders();
        RiderResponse winner = null;

        switch (color) {
            case "yellow":
                winner = allRiders.stream().min(Comparator.comparing(RiderResponse::getTotalTime)).orElseThrow(NoSuchElementException::new);
                break;
            case "mountain":
                winner = allRiders.stream().max(Comparator.comparing(RiderResponse::getMountainPoint)).orElseThrow(NoSuchElementException::new);
                break;
            case "green":
                winner = allRiders.stream().max(Comparator.comparing(RiderResponse::getSprintPoint)).orElseThrow(NoSuchElementException::new);
                break;
            case "white":
                allRiders = allRiders.stream().filter(cyclistResponse -> cyclistResponse.getAge()<= 26).collect(Collectors.toList());
                winner = allRiders.stream().min(Comparator.comparing(RiderResponse::getTotalTime)).orElseThrow(NoSuchElementException::new);
        }

        return winner;

    }


    public Stream<RiderResponse> getSortedList() {
        Stream<RiderResponse> sorted;
        List<RiderResponse> riderList = getAllRiders();

        sorted = riderList.stream().sorted(Comparator.comparing(RiderResponse::getTotalTime));

        return sorted;

    }
}
