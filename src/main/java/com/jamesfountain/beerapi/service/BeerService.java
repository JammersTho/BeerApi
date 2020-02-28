package com.jamesfountain.beerapi.service;

import com.jamesfountain.beerapi.entity.Beer;
import com.jamesfountain.beerapi.exception.BeerNotFoundException;
import com.jamesfountain.beerapi.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    /**
     * Returns the beer with the corresponding ID
     *
     * @param id id for the requested Beer
     * @return the Beer object
     * @throws BeerNotFoundException when id is not found
     */
    public Beer getById(int id) throws BeerNotFoundException {
        Optional<Beer> beer = beerRepository.findById(id);
        if (!beer.isPresent()) {
            throw new BeerNotFoundException();
        }

        return beer.get();
    }

    /**
     * Calling getById without providing an ID parameter will return a random beer
     * <p>
     * Depending on expected load and usage on the front end I may do this differently
     * I could have generated an ID and redirected the consumer to /beer/{randomid} which
     * would result in multiple calls to the backend but would expose the id in the url
     *
     * @return the random Beer object
     * @throws BeerNotFoundException when id is not found
     */
    public Beer getById() throws BeerNotFoundException {
        // generate a random int between 1 and 25
        int id = (int) (Math.random() * 25) + 1;
        // this is a bit of a hack because I know the id range
        // If I were working with a larger amount of data
        Optional<Beer> beer = beerRepository.findById(id);
        if (!beer.isPresent()) {
            throw new BeerNotFoundException();
        }

        return beer.get();
    }

    /**
     * Returns all beers
     *
     * @return
     */
    public List<Beer> getAllBeers() {
        List<Beer> beers = new ArrayList<>();
        beerRepository.findAll().forEach(beer -> beers.add(beer));

        return beers;
    }

    public List<Beer> getPage(int start, int pageSize) {
        List<Beer> beers = new ArrayList<>();
        Pageable page = PageRequest.of(start, pageSize);
        beerRepository.findAll(page).get().forEach(beer -> beers.add(beer));

        return beers;
    }
}
