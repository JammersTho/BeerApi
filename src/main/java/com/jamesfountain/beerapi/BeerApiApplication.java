package com.jamesfountain.beerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.jamesfountain.beerapi")
@EntityScan("com.jamesfountain.beerapi")
public class BeerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeerApiApplication.class, args);
    }

}
