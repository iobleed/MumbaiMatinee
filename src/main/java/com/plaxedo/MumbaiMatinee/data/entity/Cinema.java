package com.plaxedo.MumbaiMatinee.data.entity;

import org.springframework.data.annotation.Id;

public class Cinema {

    @Id
    private String id;

    private String name;
    private String city;
    private Movie[] movie;
}
