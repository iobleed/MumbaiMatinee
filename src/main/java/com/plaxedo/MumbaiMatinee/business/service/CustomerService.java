package com.plaxedo.MumbaiMatinee.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private MovieService movieService;

    public void run(){
        System.out.println("Running Customer Services");
        movieService.listMovies();
    }
}
