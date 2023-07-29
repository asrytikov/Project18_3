package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint){
        try {
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();

            logger.info("Method " + methodName + " with patameters " + Arrays.asList(arguments) + " will execute");

       /* Comment comment = new Comment();
        comment.setText("Some text");
        Object[] newArg = {comment};*/
            joinPoint.proceed();
            //logger.info("Method executed and returned " + returnMethodInfo);
            return "FAILED";
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
