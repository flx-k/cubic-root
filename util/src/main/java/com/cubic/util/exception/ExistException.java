package com.cubic.util.exception;

public class ExistException extends Exception{
    public ExistException() {
        super();
    }
    public ExistException(String msg) {
        super(msg+"-已存在");
    }
}
