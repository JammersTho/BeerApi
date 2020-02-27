package com.jamesfountain.beerapi;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Beer {

    @Id
    private int id;
    private String name;
    private String tagline;
    private String first_brewed;
    private String description;
    private String image_url;
    private Double abv;

}
