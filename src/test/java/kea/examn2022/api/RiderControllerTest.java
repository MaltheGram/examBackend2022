package kea.examn2022.api;

import kea.examn2022.Entity.Rider;
import kea.examn2022.Repository.RiderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class RiderControllerTest {

    @Autowired
    RiderRepository repo;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp(@Autowired RiderRepository repo) {
        Rider rider = new Rider(3,23,25,"Malthe",24);


        repo.save(rider);

    }

    @AfterEach
    void tearDown(@Autowired RiderRepository repo) {
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