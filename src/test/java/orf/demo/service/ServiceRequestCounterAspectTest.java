package orf.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ServiceRequestCounterAspectTest {

    @Mock
    private RequestCounter requestCounter;

    @InjectMocks
    private ServiceRequestCounterAspect aspect;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testIncrementCounter_CallsRequestCounter() {
        aspect.incrementCounter();
        verify(requestCounter, times(1)).incrementAndGet();
    }
}