package com.exception;

/**
 * Created by zheng1617 on 16-7-20.
 */
public class UserExistException extends Exception{
    public UserExistException() {
        super();
    }
    public UserExistException(String message) {
        super(message);
    }
    public UserExistException(Throwable cause) {
        super(cause);
    }
    public UserExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
