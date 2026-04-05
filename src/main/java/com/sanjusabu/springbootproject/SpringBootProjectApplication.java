package com.sanjusabu.springbootproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectApplication.class, args);
    }


    @Override
    public void run(String... args) {
        log.info("Application started");
    }
}
