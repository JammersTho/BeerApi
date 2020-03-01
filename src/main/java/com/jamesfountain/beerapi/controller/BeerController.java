package com.jamesfountain.beerapi.controller;

import com.jamesfountain.beerapi.entity.Beer;
import com.jamesfountain.beerapi.exception.BeerNotFoundException;
import com.jamesfountain.beerapi.service.BeerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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
        log.info("Get all called");
        return new ResponseEntity<>(service.getAllBeers(), HttpStatus.OK);
    }

    //    Use case 2: As the website I want to get a single beer
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Beer> getById(@PathVariable int id) throws BeerNotFoundException {
        log.info("Get by ID called with ID = " + id);
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    //    Use case 3: As the website I want to list beers with pagination
    @GetMapping(value = "/page", produces = "application/json")
    public ResponseEntity<List> getAllByPage(
            @RequestParam(value = "pagesize", required = false, defaultValue = "5") Integer pagesize,
            @RequestParam(value = "start", required = false, defaultValue = "0") Integer start) {
        log.info("Get page called with size = " + pagesize + " start = " + start);
        return new ResponseEntity<>(service.getPage(pagesize, start), HttpStatus.OK);
    }

    //    Use case 4: As the website I want to get a random beer
    @GetMapping(value = "/random", produces = "application/json")
    public ResponseEntity<Beer> getRandom() throws BeerNotFoundException {
        log.info("Get random called");
        return new ResponseEntity<>(service.getById(), HttpStatus.OK);
    }

    //    Use case 5: As the website I want to filter beers based on name or description
    @GetMapping(value = "/filter", produces = "application/json")
    public ResponseEntity<List> filter(@RequestParam(value = "search") String searchString) {
        log.info("Filter called with string = " + searchString);
        return new ResponseEntity<>( service.filterByNameDescription(searchString), HttpStatus.OK);
    }

}
