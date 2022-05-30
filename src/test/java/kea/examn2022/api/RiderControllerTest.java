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
    void getRiders() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/riders")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(8));
    }

    @Test
    void getSingleRider() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/riders/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalTime").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.SprintPoint").value(33))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mountainPoint").value(23))
                .andExpect(MockMvcResultMatchers.jsonPath("$.riderName").value("UINTANA Nairo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(28));

    }
}