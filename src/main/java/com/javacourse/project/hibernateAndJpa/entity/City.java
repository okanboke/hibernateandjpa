package com.javacourse.project.hibernateAndJpa.entity;

import javax.persistence.*;
@Entity
@Table(name="city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;
}