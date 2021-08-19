package src.aop;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import src.servises.CalculatorService;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class AspectCache {

    private Map<String, Object> cache;
    public AspectCache() {
        cache = new HashMap<String, Object>();
    }

    @Pointcut("@annotation(MyCache)")
    private void cache() {
    }

    @Around("cache()")
    public Object aroundCachedMethods(ProceedingJoinPoint thisJoinPoint)
            throws Throwable {

        StringBuilder keyBuff = new StringBuilder();
        for (final Object arg : thisJoinPoint.getArgs()) {
            keyBuff.append(arg+"#");
        }

        String key = keyBuff.toString();
        Object result = cache.get(key);
        if (result == null) {
            result = thisJoinPoint.proceed();
            cache.put(key, result);
        }

        return result;
    }
}
