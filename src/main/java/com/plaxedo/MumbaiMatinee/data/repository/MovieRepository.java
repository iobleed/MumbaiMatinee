package com.plaxedo.MumbaiMatinee.data.repository;

import com.plaxedo.MumbaiMatinee.data.entity.Movie;
import com.plaxedo.MumbaiMatinee.data.enums.Enums;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String> {

    //public Movie findByTitle(String title);
    //public List<Movie> findByGenre(Enums.MOVIE_GENRE genre);
    //public List<Movie> findByLanguage(Enums.MOVIE_LANG lang);
}
