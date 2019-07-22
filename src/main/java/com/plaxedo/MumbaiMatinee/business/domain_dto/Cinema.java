package com.plaxedo.MumbaiMatinee.business.domain_dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cinema {

    private String name;
    private String city;
    private Movie[] movie;

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", movie=" + Arrays.toString(movie) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Movie[] getMovie() {
        return movie;
    }

    public void setMovie(Movie[] movie) {
        this.movie = movie;
    }
}
