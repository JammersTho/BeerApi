package com.jamesfountain.beerapi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends CrudRepository<Beer, Integer> {
}
