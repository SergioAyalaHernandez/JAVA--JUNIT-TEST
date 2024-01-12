package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.platzi.javatests.movies.model.Genre.*;
import static org.junit.Assert.*;

public class MovieServiceTest {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, ACTION),
                        new Movie(2, "Memento", 113, THRILLER),
                        new Movie(3, "There's Something About Mary", 119, COMEDY),
                        new Movie(4, "Super 8", 112, THRILLER),
                        new Movie(5, "Scream", 111, HORROR),
                        new Movie(6, "Home Alone", 112, COMEDY),
                        new Movie(7, "Matrix", 136, ACTION)
                ));
        movieService =  new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        System.out.println("ids --->" + getMoviesId(movies));

        assertThat(getMoviesId(movies), CoreMatchers.is(Arrays.asList(3,6)));
    }

    @Test
    public void return_movies_by_length() {

        Collection<Movie> movies1 = movieService.findMoviesByMinutes(112);

        System.out.println("ids --->" + getMoviesId(movies1));

        assertThat(getMoviesId(movies1), CoreMatchers.is(Arrays.asList(4,6)));
    }

    private static List<Integer> getMoviesId(Collection<Movie> movies1) {
        List<Integer> movieIds = movies1.stream().map(Movie::getId).collect(Collectors.toList());
        return movieIds;
    }
}