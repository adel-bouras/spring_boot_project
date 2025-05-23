package com.example.creche.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
@Entity
public class enfant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long parentId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    private String birthDate;
    
    public String getBirthDate() {
        return birthDate;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getNationality() {
        return nationality;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public long getParentId() {
        return parentId;
    }
    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
