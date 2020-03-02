package com.jamesfountain.beerapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
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
