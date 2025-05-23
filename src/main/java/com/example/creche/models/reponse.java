package com.example.creche.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
public class reponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column
    private long parent;

    @Column
    private long enfant;

    @Column
    private Boolean isAccepted;

    public void setId(long id) {
        this.id = id;
    }
    public void setIsAccepted(Boolean isAccepted) {
        this.isAccepted = isAccepted;
    }
    public void setParent(long parent) {
        this.parent = parent;
    }
    public long getId() {
        return id;
    }
    public Boolean getIsAccepted() {
        return isAccepted;
    }
    public long getParent() {
        return parent;
    }
    public long getEnfant() {
        return enfant;
    }public void setEnfant(long enfant) {
        this.enfant = enfant;
    }
}
