package ru.godsonpeya.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.godsonpeya.movieinfoservice.model.Movie;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

    @RequestMapping(value = "/{movieId}")
    public Movie getCatalog(@PathVariable("movieId") String movieId){
        return new Movie(movieId,"test name");
    }
}
