package com.javagrad.demo.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerUnitTests {

    @Test
    public void testSayHello() throws Exception {
       HelloController helloController = new HelloController();
       Model model = new BindingAwareModelMap();
       String result = helloController.sayHello("World",model);
       assertEquals("hello",result);
       assertEquals("World",model.asMap().get("user"));
    }
}
