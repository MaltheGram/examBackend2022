package kea.examn2022.Entity;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Team")
@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Rider> riderList = new HashSet<>();

    private String teamName;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void addRiderToTeam(Rider rider){
        this.riderList.add(rider);
        rider.setTeam(this);
    }

    public void addRidersToTeam(Set<Rider> riders){
        this.riderList.addAll(riders);
        for (Rider rider : riders){
            rider.setTeam(this);
        }
    }

    public void removeRider(Rider rider){
        this.riderList.remove(rider);
        rider.setTeam(null);
    }
    public void removeCandidates(Set<Rider> riders){
        this.riderList.removeAll(riders);
        for (Rider rider : riders) {
            rider.setTeam(null);
        }
    }


}
