package com.plaxedo.MumbaiMatinee.business.service;

import com.plaxedo.MumbaiMatinee.business.domain_dto.Cinema;
import com.plaxedo.MumbaiMatinee.data.entity.Movie;
import com.plaxedo.MumbaiMatinee.data.enums.Enums;
import com.plaxedo.MumbaiMatinee.data.repository.MovieRepository;
import com.plaxedo.MumbaiMatinee.web.cli.CliController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieLookUpService movieLookUpService;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public void addMovie(){


        Movie movie = new Movie();
        System.out.println("Enter Movie Title");
        String name = CliController.scanner.nextLine();
        movie.setTitle(name);

        System.out.println("Enter Movie Desc");
        String desc = CliController.scanner.nextLine();
        movie.setDesc(desc);

        movie.setGenre(Enums.MOVIE_GENRE.SCI_FI);
        movie.setLang(Enums.MOVIE_LANG.ENGLISH);
        movieRepository.save(movie);

        System.out.println("Added New " + movie);
    }

    private List<Movie> retrieveAllMovie(){
        return movieRepository.findAll();
    }

    public void listMovies(){
        List<Movie> movieList = retrieveAllMovie();
        if(!movieList.isEmpty()){
            System.out.println("List of Movies running:");
            movieList.forEach(
              movie -> {
                  System.out.println(movie);
              }
            );
        }
        else {
            System.out.println("No Movie in Repository");
        }
        try {
            listMoviesInCinema();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listMoviesInCinema() throws  Exception{
        /*
        RestTemplate restTemplate = new RestTemplate();
        Cinema cinema = restTemplate.getForObject("https://0a1fb939-4f0d-44ed-a508-18a4d82e8275.mock.pstmn.io/get",
                Cinema.class);
        System.out.println("Movies in cinema\n"+cinema);
        */
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<Cinema> page1 = movieLookUpService.listMovies();
        CompletableFuture<Cinema> page2 = movieLookUpService.listMovies();
        CompletableFuture<Cinema> page3 = movieLookUpService.listMovies();

        // Wait until they are all done
        CompletableFuture.allOf(page1,page2,page3).join();

        // Print results, including elapsed time
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
        System.out.println("--> " + page1.get());
        System.out.println("--> " + page2.get());
        System.out.println("--> " + page3.get());

    }
}
