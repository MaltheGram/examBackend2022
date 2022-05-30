package kea.examn2022.api;


import kea.examn2022.DTO.RiderRequest;
import kea.examn2022.DTO.RiderResponse;
import kea.examn2022.Service.RiderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/riders")
public class RiderController {

    RiderService riderService;

    public RiderController(RiderService riderService) {
        this.riderService = riderService;
    }

    @GetMapping("/{id}")
    public RiderResponse getRider(@PathVariable Long id) {
        return riderService.getSingleRider(id);
    }

    @GetMapping()
    public List<RiderResponse> getAllRiders(@RequestParam(value = "team",required = false) String team) {
        return riderService.getAllRiders(team);
    }

    @PostMapping()
    public void addRider(@RequestBody RiderRequest rider) {
        riderService.addRider(rider);
    }

    @PutMapping("/{id}")
    public RiderResponse updateCandidate(@PathVariable Long id, @RequestBody RiderRequest rider) {
        return riderService.updateRider(id, rider);
    }
    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable Long id) {
        riderService.deleteRider(id);
    }

}
