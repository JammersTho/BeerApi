package com.jamesfountain.beerapi.service;

import com.jamesfountain.beerapi.entity.Beer;
import com.jamesfountain.beerapi.exception.BeerNotFoundException;
import com.jamesfountain.beerapi.repository.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
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
     * @throws BeerNotFoundException when id is not found - this should never happen
     */
    public Beer getById() throws BeerNotFoundException {
        // generate a random int between 1 and the count of beers
        int randomId = (int) (Math.random() * beerRepository.count()) + 1;
        Optional<Beer> beer = beerRepository.findById(randomId);
        if (!beer.isPresent()) {
            log.error("Random beer not found, likely a data issue. Random id - " + randomId);
            throw new BeerNotFoundException();
        }
        return beer.get();
    }

    /**
     * Returns all beers
     *
     * @return  all beers
     */
    public List<Beer> getAllBeers() {
        List<Beer> beers = new ArrayList<>();
        beerRepository.findAll().forEach(beer -> beers.add(beer));
        return beers;
    }

    /**
     * Returns a paginated list of Beers
     *
     * @param start     zero based page index
     * @param pageSize  size of the page to be returned
     * @return          paginated list of Beers
     */
    public List<Beer> getPage(int start, int pageSize) {
        Pageable page = PageRequest.of(start, pageSize);
        return beerRepository.findBy(page);
    }

    /**
     * Return Beers containing the specified string in name or description columns
     *
     * With more time I would have added pagination or a limit to this function
     *
     * @param searchString the string to filter on
     * @return list of beers containing the string in name or description
     */
    public List<Beer> filterByNameDescription(String searchString) {
        return beerRepository.filterByNameDescription(searchString);
    }
}
