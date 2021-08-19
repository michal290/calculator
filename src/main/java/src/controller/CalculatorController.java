package src.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import src.aop.MyCache;
import src.dto.CalculatorDTO;
import org.springframework.web.bind.annotation.*;
import src.servises.CalculatorService;

@RequestMapping("/calculator")
@RestController
@AllArgsConstructor
public class CalculatorController {

    private CalculatorService service;

    @CrossOrigin
    @GetMapping("/calculate")
    public String calculate(@RequestParam(value = "calculation") String calculator) throws JsonMappingException, JsonProcessingException {
        CalculatorDTO calculatorDTO = new ObjectMapper().readValue(calculator, CalculatorDTO.class);
        return this.service.calculate(calculatorDTO.getOperator(),calculatorDTO.getLeft(), calculatorDTO.getRight());
    }




}
