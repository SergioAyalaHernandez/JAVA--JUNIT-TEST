package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;
import java.util.Objects;

public class MovieRepositoryImpl implements MovieRepository {

    JdbcTemplate jdbcTemplate;

    public MovieRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {

        Object[] args = {id};

        return jdbcTemplate.queryForObject("select * from movies where id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("select * from movies",movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("insert into movies (name,minutes,genre) values(?,?,?)",
                movie.getName(), movie.getMinutes(), String.valueOf(movie.getGenre()));
    }

    private static final RowMapper<Movie> movieMapper = (rs, rowNum) ->
            new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("minutes"),
            Genre.valueOf(rs.getString("genre"))
    );
}
