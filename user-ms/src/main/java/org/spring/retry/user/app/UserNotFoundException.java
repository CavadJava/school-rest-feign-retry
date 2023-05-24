package org.spring.retry.user.app;

public class UserNotFoundException extends RuntimeException{

    private String message;

    public UserNotFoundException(){

    }

    public UserNotFoundException(String message){
        this.message = message;
    }
}
