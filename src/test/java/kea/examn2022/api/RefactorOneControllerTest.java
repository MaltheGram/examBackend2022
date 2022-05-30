package kea.examn2022.api;

import kea.examn2022.Entity.RefactorEntity;
import kea.examn2022.Repository.RefactorEntityRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class RefactorOneControllerTest {

    @Autowired
    RefactorEntityRepository repo;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp(@Autowired RefactorEntityRepository repo) {
        RefactorEntity entity = RefactorEntity.builder()
                .RefactorFieldOne("1")
                .RefactorFieldTwo("2")
                .RefactorFieldThree("3")
                .RefactorFieldFour(4)
                .build();
//        RefactorEntity entity = new RefactorEntity("1","2","3",4);

        repo.save(entity);

    }

    @AfterEach
    void tearDown(@Autowired RefactorEntityRepository repo) {
        repo.deleteAll();

    }

    @Test
    void getRefactors() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/refactor")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(4));
    }

    @Test
    void getSingleEntity() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/accounts/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.RefactorFieldOne").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.RefactorFieldTwo").value("2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.RefactorFieldThree").value("3"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.RefactorFieldFour").value(4));
    }


    @Test
    void addSingleEntity() {
    }
}