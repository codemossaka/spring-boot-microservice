package ru.godsonpeya.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.godsonpeya.ratingsdataservice.model.Rating;

@RestController
@RequestMapping(value = "/ratingsData")
public class RatingsResource {

    @RequestMapping(value = "/{movieId}")
    public Rating getCatalog(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 4);
    }
}
