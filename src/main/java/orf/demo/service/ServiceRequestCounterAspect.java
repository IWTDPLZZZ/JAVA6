package orf.demo.service;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceRequestCounterAspect {

    private final RequestCounter requestCounter;

    @Autowired
    public ServiceRequestCounterAspect(RequestCounter requestCounter) {
        this.requestCounter = requestCounter;
    }

    @AfterReturning("execution(* orf.demo.service.SpellCheckService.*(..))")
    public void incrementCounter() {
        requestCounter.incrementAndGet();
    }
}