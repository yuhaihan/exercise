package com.covid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Covid19Application {

    public static void main(String[] args) {
        SpringApplication.run(Covid19Application.class, args);
    }

}
