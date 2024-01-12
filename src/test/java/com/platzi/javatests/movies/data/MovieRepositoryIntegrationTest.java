package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Genre;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.platzi.javatests.movies.model.Movie;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryImpl movieRepository;
    private DriverManagerDataSource dataSource;

    @Before
    public void setUp() throws Exception {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL","sa","sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(),new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryImpl(jdbcTemplate);
    }

    @Test
    public void load_all_movies_that() throws SQLException {

       Collection<Movie> movies = movieRepository.findAll();
        System.out.println(movies);
        assertThat(movies, is(Arrays.asList(
                new Movie(1,"dark Knight",152,Genre.ACTION),
                new Movie(2,"Memento",113,Genre.THRILLER),
                new Movie(3,"Matrix",136,Genre.ACTION)
        )));
    }


    @Test
    public void load_movie_by_id() throws SQLException {
        Movie movie = movieRepository.findById(2);
        assertThat(movie,is(new Movie(2,"Memento",113, Genre.THRILLER)));
    }


    @Test
    public void insert_a_movie() throws SQLException{
        Movie movie = new Movie(4,"super 8",119,Genre.THRILLER);

        movieRepository.saveOrUpdate(movie);
        Movie movieFromDB =  movieRepository.findById(4);
        System.out.println(movieFromDB);
        assertThat(movieFromDB, is(movie));
    }

    @After
    public void dummy() throws Exception{
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files ");
    }
}