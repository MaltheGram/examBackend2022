package kea.examn2022.Configuration;

import kea.examn2022.Entity.RefactorEntity;
import kea.examn2022.Entity.RefactorEntityTwo;
import kea.examn2022.Repository.RefactorEntityRepository;
import kea.examn2022.Repository.RefactorEntityTwoRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Component
@Profile("!test")
public class DummyData implements ApplicationRunner  {

    RefactorEntityRepository refactorRepoOne;
    RefactorEntityTwoRepository refactorRepoTwo;

    public DummyData(RefactorEntityRepository refactorRepoOne, RefactorEntityTwoRepository refactorRepoTwo) {
        this.refactorRepoOne = refactorRepoOne;
        this.refactorRepoTwo = refactorRepoTwo;
    }

    public void fakeData(){
        RefactorEntity re = new RefactorEntity("Entity1","Field2","Field3",1);
        RefactorEntity re2 = new RefactorEntity("Entity2","Field2","Field3",2);
        RefactorEntity re3 = new RefactorEntity("Entity3","Field2","Field3",3);


        RefactorEntityTwo ret = new RefactorEntityTwo("Entity4","Field2","Field3",3);
        RefactorEntityTwo ret2 = new RefactorEntityTwo("Entity5","Field2","Field3",4);
        RefactorEntityTwo ret3 = new RefactorEntityTwo("Entity6","Field2","Field3",5);

        refactorRepoOne.save(re);
        refactorRepoOne.save(re2);
        refactorRepoOne.save(re3);

        refactorRepoTwo.save(ret);
        refactorRepoTwo.save(ret2);
        refactorRepoTwo.save(ret3);


        System.out.println("CREATED TEST DATA");

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        refactorRepoOne.deleteAll();
        refactorRepoTwo.deleteAll();

        fakeData();

    }
}
