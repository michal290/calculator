package src.enums;


import src.aop.MyCache;

import java.util.function.BiFunction;

public enum OperationEnum {
    plus         ((a,b) -> a+"+"+b+"="+(a+b)),
    minus        ((a,b) -> a+"-"+b+"="+(a-b)),
    multiply     ((a,b) -> a+"*"+b+"="+(a*b)),
    divide       ((a,b) -> a+"/"+b+"="+(a/b));

    private BiFunction<Integer, Integer, String> func;

    OperationEnum(BiFunction<Integer, Integer, String> func) {
        this.func = func;
    }

    public String calc(int a, int b) {
        return func.apply(a,b);
    }
}
