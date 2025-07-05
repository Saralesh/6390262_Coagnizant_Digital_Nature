package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private double salary;
    private boolean permanent;

    @ManyToOne
    private Department department;

    @ManyToMany
    private List<Skill> skillList;

    // getters and setters
}