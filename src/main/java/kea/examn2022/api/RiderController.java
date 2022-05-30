package kea.examn2022.api;


import kea.examn2022.DTO.RiderRequest;
import kea.examn2022.DTO.RiderResponse;
import kea.examn2022.Service.RiderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

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

    @GetMapping("/winner/{color}")
    RiderResponse getWinner(@PathVariable String color) {
        return riderService.getWinner(color);
    }

    @GetMapping("/sorted")
    public Stream<RiderResponse> getSortedList(){
        return riderService.getSortedList();
    }

    @PostMapping()
    public void addRider(@RequestBody RiderRequest rider) {
        riderService.addRider(rider);
    }

    @PutMapping("/{id}")
    public RiderResponse updateRider(@PathVariable Long id, @RequestBody RiderRequest rider) {
        return riderService.updateRider(rider, id);
    }
    @DeleteMapping("/{id}")
    public void deleteRider(@PathVariable Long id) {
        riderService.deleteRider(id);
    }

}
