package com.gla.entity;

import jakarta.persistence.Entity;

@Entity
public class Employee {

    private Long id;
    private String name;
    private String email;

    public Employee() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

}
