package kea.examn2022.Service;

import kea.examn2022.DTO.RefactorOneRequest;
import kea.examn2022.DTO.RefactorOneResponse;
import kea.examn2022.Entity.RefactorEntity;
import kea.examn2022.Error.Exception40x;
import kea.examn2022.Repository.RefactorEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefactorOneService {
    RefactorEntityRepository refactorRepoOne;

    public RefactorOneService(RefactorEntityRepository refactorRepoOne) {
        this.refactorRepoOne = refactorRepoOne;
    }

    public List<RefactorOneResponse> getRefactorOne(){
        List<RefactorEntity> refactors = refactorRepoOne.findAll();

        return RefactorOneResponse.convertFromEntity(refactors);
    }

    public RefactorOneResponse getSingleEntity(Long id) {
        RefactorEntity entity = refactorRepoOne.findById(id).orElseThrow( () -> new Exception40x("Not a valid search"));

        return new RefactorOneResponse(entity);
    }

    public RefactorOneResponse addSingleEntity(RefactorOneRequest request){
        RefactorEntity entity = refactorRepoOne.save(new RefactorEntity(request));

        return new RefactorOneResponse(entity);

    }

}
