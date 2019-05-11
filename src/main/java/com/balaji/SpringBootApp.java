package com.balaji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Balaji Vijaykumar on 3/15/2018.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.balaji")
public class SpringBootApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootApp.class, args);
    }
}