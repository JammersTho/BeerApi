package com.jamesfountain.beerapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("beer")
public class BeerController {

    private final BeerService service;

    public BeerController(BeerService service) {
        this.service = service;
    }

    //    Use case 1: As the website I want to list all beers
    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List> getAll() {
        return new ResponseEntity<>(service.getAllBeers(), HttpStatus.OK);
    }

    //    Use case 2: As the website I want to get a single beer
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Beer> getById(@PathVariable int id) throws BeerNotFoundException {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

//    Use case 3: As the website I want to list beers with pagination
//    Use case 4: As the website I want to get a random beer

}
