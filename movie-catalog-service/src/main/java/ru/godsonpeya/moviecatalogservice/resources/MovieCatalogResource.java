package ru.godsonpeya.moviecatalogservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import ru.godsonpeya.moviecatalogservice.model.CatalogItem;
import ru.godsonpeya.moviecatalogservice.model.Movie;
import ru.godsonpeya.moviecatalogservice.model.UserRating;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/catalog")
public class MovieCatalogResource {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsData/users/" + userId, UserRating.class);
        return userRating.getUserRating().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service:8082/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "Desc", rating.getRating());
        }).collect(Collectors.toList());
    }
}
/*
Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/"+rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
 */