# Java test assignment

Create a REST service using [spring-boot](https://spring.io/guides/gs/rest-service/).
Service should accepts POST requests with JSON payload and return a string.

For example, given the request 
```
{  
    "operator":"plus",  
    "left": 5,  
    "right": 7  
}  
```
the response should be `"5+7=12"`.  

Operator can be "plus", "minus", "multiply", "divide".  
Operands are integers.

Write unit tests.

