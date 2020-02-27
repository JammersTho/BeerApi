package com.jamesfountain.beerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    public Beer getById(int id) throws BeerNotFoundException {
        if (id == 404) {
            throw new BeerNotFoundException();
        }
        return beerRepository.findById(id).get();
    }

    public List<Beer> getAllBeers() {
        List<Beer> array = new ArrayList<>();

        beerRepository.findAll().forEach(beer -> array.add(beer));

        return array;
    }
}
