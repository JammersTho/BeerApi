package com.jamesfountain.beerapi;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeerServiceTest {

    BeerService beerService = new BeerService();

    @Test(expected = BeerNotFoundException.class)
    public void whenBeerNotFound_exceptionThrown() throws BeerNotFoundException {
        beerService.getById(404);
    }

    @Test
    public void whenGetById_beerReturned() throws BeerNotFoundException {
        Beer beer = new Beer();

        beer.setId(1);
        beer.setName("Potato");
        beer.setTagline("Potato");
        beer.setFirst_brewed("Potato");
        beer.setDescription("Potato");
        beer.setImage_url("Potato");
        beer.setAbv(1.1F);

        assertEquals(beer, beerService.getById(1));
    }
}
