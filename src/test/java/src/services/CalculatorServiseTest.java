package src.services;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import src.enums.OperationEnum;
import src.servises.CalculatorService;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CalculatorServiseTest {

    private ListAppender<ILoggingEvent> listAppender;

    @Before
    public void beforeTest() {
        Logger logger = (Logger) LoggerFactory.getLogger(CalculatorService.class);

        this.listAppender = new ListAppender<>();
        this.listAppender.start();
        logger.addAppender(listAppender);

    }

    @Autowired
    private CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testPlusAndMinus() throws Throwable {

        calculatorService.calculate("plus", 5, 7);
        calculatorService.calculate("minus", 5, 7);
        List<ILoggingEvent> logsList = listAppender.list;
        assertEquals(2, logsList.size());
    }

    @Test
    public void testPlusTwice() throws Throwable {
        calculatorService.calculate("plus", 5, 7);
        calculatorService.calculate("plus", 5, 7);
        List<ILoggingEvent> logsList = listAppender.list;
        assertEquals(1, logsList.size());
    }


}
