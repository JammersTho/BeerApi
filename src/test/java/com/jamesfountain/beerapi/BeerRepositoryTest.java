package com.jamesfountain.beerapi;

import com.jamesfountain.beerapi.entity.Beer;
import com.jamesfountain.beerapi.repository.BeerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BeerRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    BeerRepository beerRepository;

    @Test
    public void whenFindById_thenReturnBeer() {
        // given
        Beer ipa = new Beer();
        ipa.setId(1);
        ipa.setName("ipa");
        ipa.setTagline("ipa");
        ipa.setFirst_brewed("ipa");
        ipa.setDescription("ipa");
        ipa.setImage_url("ipa");
        ipa.setAbv(1.1);
        entityManager.persist(ipa);
        entityManager.flush();

        // when
        Optional<Beer> found = beerRepository.findById(ipa.getId());

        // then
        assertThat(found.get().getName()).isEqualTo(ipa.getName());
    }

//    @Test
//    public void whenFilterByNameDescription_thenReturnBeer() {
//        // given
//        Beer ipa = new Beer();
//        ipa.setId(1);
//        ipa.setName("ipa");
//        ipa.setTagline("ipa");
//        ipa.setFirst_brewed("ipa");
//        ipa.setDescription("ipa");
//        ipa.setImage_url("ipa");
//        ipa.setAbv(1.1);
//        Beer beer = new Beer();
//        beer.setId(2);
//        beer.setName("beer");
//        beer.setTagline("ipa");
//        beer.setFirst_brewed("ipa");
//        beer.setDescription("beer");
//        beer.setImage_url("ipa");
//        beer.setAbv(1.1);
//        entityManager.persist(ipa);
//        entityManager.flush();
//
//        // when
//        List<Beer> found = beerRepository.filterByNameDescription("ip");
//
//        // then
//        assertThat(found.size()).isEqualTo(1);
//    }

}
