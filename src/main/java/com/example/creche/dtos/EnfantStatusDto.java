package com.example.creche.dtos;

public class EnfantStatusDto{
    private String name;
    private boolean isAccepted;
    EnfantStatusDto(String name , boolean isAccepted){
        this.isAccepted = isAccepted;
        this.name = name;
    }
    public String getName() {
        return name;
    }public void setAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }public void setName(String name) {
        this.name = name;
    }
    public boolean getisActivated(){
        return isAccepted;
    }
}