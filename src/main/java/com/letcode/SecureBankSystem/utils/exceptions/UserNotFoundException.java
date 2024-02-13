package com.letcode.SecureBankSystem.utils.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String str){
        super(str);
    }
}
