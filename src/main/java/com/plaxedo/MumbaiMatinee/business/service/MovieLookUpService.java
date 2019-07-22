package com.plaxedo.MumbaiMatinee.business.service;

import com.plaxedo.MumbaiMatinee.business.domain_dto.Cinema;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class MovieLookUpService {

    private final RestTemplate restTemplate;

    public MovieLookUpService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<Cinema> listMovies() throws Exception {
        //restTemplate = new RestTemplate();
        Cinema cinema = restTemplate.getForObject("https://0a1fb939-4f0d-44ed-a508-18a4d82e8275.mock.pstmn.io/get",
                Cinema.class);

        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(cinema);
    }
}
