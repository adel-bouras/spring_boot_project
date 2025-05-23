package com.example.creche.dtos;

public class loginDTO {
    private String email;
    private String password;
        public loginDTO(String email) {
        this.email = email;
    }
    public void setEmail(String email) {
        this.email = email;
    }public void setPassword(String password) {
        this.password = password;
    }public String getEmail() {
        return email;
    }public String getPassword() {
        return password;
    }
    
}
