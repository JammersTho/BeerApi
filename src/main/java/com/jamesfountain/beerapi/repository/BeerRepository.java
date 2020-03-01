package com.jamesfountain.beerapi.repository;

import com.jamesfountain.beerapi.entity.Beer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends PagingAndSortingRepository<Beer, Integer> {

    // PagingAndSortingRepository adds methods to CrudRepo which make pagination easy
    List<Beer> findBy(Pageable pageable);


    @Query(value = "SELECT b " +
            "       FROM Beer b " +
            "       WHERE LOWER(b.name)        LIKE LOWER(concat('%', concat(?1, '%'))) " +
            "       OR    LOWER(b.description) LIKE LOWER(concat('%', concat(?1, '%')))")
    List<Beer> filterByNameDescription(String searchString);


}
