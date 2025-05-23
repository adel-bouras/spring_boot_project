package com.example.creche.dtos;

public class parentDto {
        private String email;
        private long id;
    public parentDto(String email , long id){
        this.id = id;
        this.email = email;
    }
    public void setId(long id) {
        this.id = id;
    }public long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }public void setEmail(String email) {
        this.email = email;
    }
}
