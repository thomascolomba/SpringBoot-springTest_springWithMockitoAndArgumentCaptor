package com.thomas;

import com.thomas.repository.HelloRepository;
import com.thomas.services.HelloService;
import com.thomas.services.HelloServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HelloServiceMockTest {

    @Mock
    private HelloRepository helloRepository;

    @InjectMocks
    private HelloService helloService = new HelloServiceImpl();

    @Test
    void testReturnedValueWithMockito() {
    	//Arrange
    	// no arrange instruction...
    	//Act
    	helloService.get("myString1");
    	//Assert
    	ArgumentCaptor<String> myCaptor = ArgumentCaptor.forClass(String.class);
    	Mockito.verify(helloRepository).returnParam(myCaptor.capture());
        assertEquals("myString1stringAddedByHelloService", myCaptor.getValue());
    }
}