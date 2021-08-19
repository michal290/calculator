package src.servises;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import src.aop.MyCache;
import src.enums.OperationEnum;

@Service
public class CalculatorService {

    final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    @MyCache
    public String calculate(String operator, int left, int right) {
        logger.info("calc applay");
        return OperationEnum.valueOf(operator).calc(left, right);

    }

}
