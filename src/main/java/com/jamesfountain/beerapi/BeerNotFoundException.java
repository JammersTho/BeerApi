package com.jamesfountain.beerapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Beer not found")
public class BeerNotFoundException extends Exception {
}