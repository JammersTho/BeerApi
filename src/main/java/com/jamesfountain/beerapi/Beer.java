package com.jamesfountain.beerapi;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Beer {

    private int id;
    private String name;
    private String tagline;
    private String first_brewed;
    private String description;
    private String image_url;
    private Float abv;

}
