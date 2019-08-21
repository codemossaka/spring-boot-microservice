package ru.godsonpeya.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.godsonpeya.ratingsdataservice.model.Rating;
import ru.godsonpeya.ratingsdataservice.model.UserRating;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/ratingsData")
public class RatingsResource {

    @RequestMapping(value = "/{movieId}")
    public Rating getCatalog(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping(value = "/users/{userId}")
    public UserRating getRating(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("4564", 3)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }


}
