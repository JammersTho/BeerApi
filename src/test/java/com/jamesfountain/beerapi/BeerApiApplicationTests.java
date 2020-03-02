package com.jamesfountain.beerapi;

import com.jamesfountain.beerapi.controller.BeerController;
import com.jamesfountain.beerapi.entity.Beer;
import com.jamesfountain.beerapi.exception.BeerNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BeerApiApplicationTests {

    @Autowired
    private BeerController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void getAllIsCalled_multipleReturned() {
        ResponseEntity<List> response = controller.getAll();
        assertThat(response.getStatusCode().is2xxSuccessful());
        assertEquals(25, response.getBody().size());
    }

    @Test
    public void getByIdIsCalled_oneReturned() throws BeerNotFoundException {
        ResponseEntity<Beer> response = controller.getById(1);
        assertThat(response.getStatusCode().is2xxSuccessful());
        assertEquals(1, response.getBody().getId());
    }

    @Test
    public void getRandomIsCalled_oneReturned() throws BeerNotFoundException {
        ResponseEntity<Beer> response = controller.getRandom();
        assertThat(response.getStatusCode().is2xxSuccessful());
        assertThat(response.getBody().getName()).isNotBlank();
    }

    @Test
    public void getPageIsCalled_fiveReturned() {
        ResponseEntity<List> response = controller.getAllByPage(5, 1);
        assertThat(response.getStatusCode().is2xxSuccessful());
        assertEquals(5, response.getBody().size());
    }

}
