package com.plaxedo.MumbaiMatinee.data.repository;

import com.plaxedo.MumbaiMatinee.data.entity.Cinema;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CinemaRepository extends MongoRepository<Cinema, String> {

    public List<Cinema> findCinemaByCity(String city);
}
