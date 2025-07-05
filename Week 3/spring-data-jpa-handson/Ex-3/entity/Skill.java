package com.example.entity;

import javax.persistence.*;

@Entity
public class Skill {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    // getters and setters
}