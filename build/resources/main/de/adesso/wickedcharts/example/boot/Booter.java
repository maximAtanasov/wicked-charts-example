package de.adesso.wickedcharts.example.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("de.adesso.wickedcharts.example")
public class Booter {
	
    public static void main(String[] args) {
        SpringApplication.run(Booter.class, args);
    }

}