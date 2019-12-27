package ob.service.cosmeticsmanufacturer.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ob.service.cosmeticsmanufacturer.services.CosmeticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CosmeticsController.class)
class CosmeticsControllerTest {

    @Autowired
    MockMvc mockMvc;
//    @Autowired
//    ObjectMapper objectMapper;

    @MockBean
    CosmeticsService cosmeticsService;

    @Test
    void getCosmetics() throws Exception{
        mockMvc.perform(get("/api/v1/cosmetics/"+UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /**
     * Implement these tests and ensure quality test coverage
     */
    @Test
    void postNewCosmetics() {
    }

    @Test
    void putCosmetics() {
    }

    @Test
    void deleteCosmetics() {
    }
}