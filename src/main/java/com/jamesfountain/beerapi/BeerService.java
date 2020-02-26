package com.jamesfountain.beerapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeerService {

    public Beer getById(int id) throws BeerNotFoundException {
        if (id == 404) {
            throw new BeerNotFoundException();
        }

        Beer beer = new Beer();

        beer.setId(id);
        beer.setName("Potato");
        beer.setTagline("Potato");
        beer.setFirst_brewed("Potato");
        beer.setDescription("Potato");
        beer.setImage_url("Potato");
        beer.setAbv(1.1F);

        return beer;
    }

    public List<Beer> getAllBeers() {
        Beer beer = new Beer();

        beer.setId(1);
        beer.setName("Potato1");
        beer.setTagline("Potato1");
        beer.setFirst_brewed("Potato1");
        beer.setDescription("Potato1");
        beer.setImage_url("Potato1");
        beer.setAbv(1.1F);

        Beer beer2 = new Beer();

        beer.setId(2);
        beer.setName("Potato2");
        beer.setTagline("Potato2");
        beer.setFirst_brewed("Potato2");
        beer.setDescription("Potato2");
        beer.setImage_url("Potato2");
        beer.setAbv(2.2F);

        List<Beer> beers = new ArrayList<Beer>();
        beers.add(beer);
        beers.add(beer2);

        return beers;
    }
}
