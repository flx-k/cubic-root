package com.cubic.util.exception;

public class NotExistException extends Exception{
    public NotExistException() {
        super();
    }
    public NotExistException(String msg) {
        super(msg+"[不存在]");
    }
}
