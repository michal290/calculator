package src.controller;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class CalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("calculate plus")
    public void calculatePlus() throws Exception {

        String input = "{\"operator\":\"plus\",\"left\":5,\"right\":7}";

        mockMvc.perform(get("/calculator/calculate/").param("calculation", input))
                .andDo(print())
                .andExpect(content().string("5+7=12"));

    }

    @Test
    @DisplayName("calculate minus")
    public void calculateMinus() throws Exception {

        String input = "{\"operator\":\"minus\",\"left\":5,\"right\":7}";

        mockMvc.perform(get("/calculator/calculate/").param("calculation", input))
                .andDo(print())
                .andExpect(content().string("5-7=-2"));

    }

    @Test
    @DisplayName("calculate multiply")
    public void calculateMultiply() throws Exception {

        String input = "{\"operator\":\"multiply\",\"left\":5,\"right\":7}";

        mockMvc.perform(get("/calculator/calculate/").param("calculation", input))
                .andDo(print())
                .andExpect(content().string("5*7=35"));

    }


    @Test
    @DisplayName("calculate divide")
    public void calculateDivide() throws Exception {

        String input = "{\"operator\":\"divide\",\"left\":15,\"right\":3}";

        mockMvc.perform(get("/calculator/calculate/").param("calculation", input))
                .andDo(print())
                .andExpect(content().string("15/3=5"));

    }


}
