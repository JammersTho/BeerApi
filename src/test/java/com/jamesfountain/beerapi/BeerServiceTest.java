package com.jamesfountain.beerapi;

import com.jamesfountain.beerapi.entity.Beer;
import com.jamesfountain.beerapi.exception.BeerNotFoundException;
import com.jamesfountain.beerapi.repository.BeerRepository;
import com.jamesfountain.beerapi.service.BeerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BeerServiceTest {

    static Beer beer = new Beer();
    static Beer beer2 = new Beer();


    @Mock
    BeerRepository mockRepository;
    @InjectMocks
    BeerService beerService;

    @BeforeAll
    static void setup() {
        beer.setId(1);
        beer.setName("Potato");
        beer.setTagline("Potato");
        beer.setFirst_brewed("Potato");
        beer.setDescription("Potato");
        beer.setImage_url("Potato");
        beer.setAbv(1.1);

        beer2.setId(2);
        beer2.setName("Carrot");
        beer2.setTagline("Carrot");
        beer2.setFirst_brewed("Carrot");
        beer2.setDescription("Carrot");
        beer2.setImage_url("Carrot");
        beer2.setAbv(2.2);
    }

    @Test()
    public void whenBeerNotFound_exceptionThrown() {
        Assertions.assertThrows(BeerNotFoundException.class, () -> {
            beerService.getById(404);
        });
    }

    @Test
    public void whenGetById_beerReturned() throws BeerNotFoundException {
        Mockito.when(mockRepository.findById(1)).thenReturn(Optional.of(beer));

        assertEquals("Potato", beerService.getById(1).getName());
    }

    @Test
    public void whenGetAll_listReturned() {
        Mockito.when(mockRepository.findAll()).thenReturn(Arrays.asList(beer, beer2));

        assertEquals(2, beerService.getAllBeers().size());
    }
}
