package com.system.test;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

public class JUnit4ClassRunner extends SpringJUnit4ClassRunner {
    static {
        try{
            Log4jConfigurer.initLogging("Documents/practice/512/springmybatismission1/src/main/java/resources/log4j.properties");
        }catch (FileNotFoundException ex){
            System.out.println("Cannot Initialize log4j");
        }
    }
    public JUnit4ClassRunner(Class<?> clazz) throws InitializationError{
        super(clazz);
    }
}
