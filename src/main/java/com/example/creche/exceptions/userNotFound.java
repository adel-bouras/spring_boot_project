package com.example.creche.exceptions;

public class userNotFound extends RuntimeException{
    public userNotFound(String msg){
        super(msg);
    }
    
}
