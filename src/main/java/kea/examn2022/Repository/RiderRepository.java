package kea.examn2022.Repository;

import kea.examn2022.Entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiderRepository extends JpaRepository<Rider, Long> {

    public List<Rider> findRidersByTeam_TeamName(String team);





}
