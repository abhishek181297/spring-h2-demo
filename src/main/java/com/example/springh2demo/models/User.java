package com.example.springh2demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}
