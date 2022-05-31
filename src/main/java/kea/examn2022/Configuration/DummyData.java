package kea.examn2022.Configuration;

import kea.examn2022.Entity.Rider;
import kea.examn2022.Entity.Team;
import kea.examn2022.Repository.RiderRepository;
import kea.examn2022.Repository.TeamRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Controller
@Component
@Profile("!test")
public class DummyData implements ApplicationRunner  {

    RiderRepository riderRepository;
    TeamRepository teamRepository;

    public DummyData(RiderRepository riderRepository, TeamRepository refactorRepoTwo) {
        this.riderRepository = riderRepository;
        this.teamRepository = refactorRepoTwo;
    }

    public void fakeData(){
        Team team1 = new Team("Team-Arkéa-Samsic");

        Rider rider1 = new Rider(LocalTime.of(1,55,32),35,22,"PICHON Laurent",26);
        Rider rider2 = new Rider(LocalTime.of(4,5),33,23,"QUINTANA Nairo",28);
        Rider rider3 = new Rider(LocalTime.of(2,23),34,12,"BARGUIL Warren",30);

        team1.addRidersToTeam(Set.of(rider1,rider2,rider3));

        Team team2 = new Team("Groupama-FDJ");

        Rider rider4 = new Rider(LocalTime.of(2,32),34,34,"STORER Michael",33);
        Rider rider5 = new Rider(LocalTime.of(3,52),45,52," GENIETS Kevin",23);

        team2.addRidersToTeam(Set.of(rider4,rider5));

        Team team3 = new Team("DSM");

        Rider rider6 = new Rider(LocalTime.of(2,51),12,31,"BOL Cees",27);
        Rider rider7 = new Rider(LocalTime.of(2,53),41,52,"DEGENKOLB John",25);

        team3.addRidersToTeam(Set.of(rider6,rider7));


        teamRepository.saveAll(List.of(
                team1,
                team2,
                team3
        ));


        System.out.println("CREATED TEST DATA");

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        riderRepository.deleteAll();
        teamRepository.deleteAll();

        fakeData();

    }
}
