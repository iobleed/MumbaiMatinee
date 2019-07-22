package com.plaxedo.MumbaiMatinee.business.service;

import com.plaxedo.MumbaiMatinee.data.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private MovieService movieService;

    public void run(){
        System.out.println("Running Admin Services");
        movieService.addMovie();
    }
}
