package com.example.creche.dtos;

public class loginDTO {
    private String email;
    private String password;
    private long id;
        public loginDTO(String email , long id) {
        this.email = email;
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }public void setPassword(String password) {
        this.password = password;
    }public String getEmail() {
        return email;
    }public String getPassword() {
        return password;
    }public long getId() {
        return id;
    }public void setId(long id) {
        this.id = id;
    }
    
}
