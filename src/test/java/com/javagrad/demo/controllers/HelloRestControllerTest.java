package com.javagrad.demo.controllers;

import com.javagrad.demo.entities.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerTest {

    @Autowired
    TestRestTemplate template;

    @Test
    public void greetWithoutName(){
        ResponseEntity<Greeting> entity = template.getForEntity("/rest",Greeting.class);
        assertEquals(HttpStatus.OK,entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON_UTF8,entity.getHeaders().getContentType());
        Greeting response = entity.getBody();
        assertEquals("Hello, World!",response.getGreeting());

    }

    @Test
    public void greetWithName(){
        ResponseEntity<Greeting> entity = template.getForEntity("/rest?name=Neeraj",Greeting.class);
        assertEquals(HttpStatus.OK,entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON_UTF8,entity.getHeaders().getContentType());
        Greeting response = entity.getBody();
        assertEquals("Hello, Neeraj!",response.getGreeting());

    }

    @Test
    public void greetWithName2(){
        //getForObject returns the de-serialized response directly but does not allow access to headers
        Greeting response = template.getForObject("/rest?name=Neeraj",Greeting.class);
        assertEquals("Hello, Neeraj!",response.getGreeting());
    }

}
