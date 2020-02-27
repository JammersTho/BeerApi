package com.jamesfountain.beerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    public Beer getById(int id) throws BeerNotFoundException {
        Optional<Beer> beer = beerRepository.findById(id);
        if (!beer.isPresent()) {
            throw new BeerNotFoundException();
        }

        return beer.get();
    }

    public List<Beer> getAllBeers() {
        List<Beer> beers = new ArrayList<>();
        beerRepository.findAll().forEach(beer -> beers.add(beer));

        return beers;
    }
}
