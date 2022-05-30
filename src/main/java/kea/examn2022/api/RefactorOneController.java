package kea.examn2022.api;


import kea.examn2022.DTO.RefactorOneRequest;
import kea.examn2022.DTO.RefactorOneResponse;
import kea.examn2022.Service.RefactorOneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/refactor")
@CrossOrigin
public class RefactorOneController {
    RefactorOneService refactorOneService;

    public RefactorOneController(RefactorOneService refactorOneService) {
        this.refactorOneService = refactorOneService;
    }

    @GetMapping
    public List<RefactorOneResponse> getRefactors(){
        return refactorOneService.getRefactorOne();
    }

    @GetMapping("/{id}")
    public RefactorOneResponse getSingleEntity(@PathVariable Long id) throws Exception {
        return refactorOneService.getSingleEntity(id);
    }

    @PostMapping()
    public RefactorOneResponse addSingleEntity(RefactorOneRequest request){
        return refactorOneService.addSingleEntity(request);
    }


}
