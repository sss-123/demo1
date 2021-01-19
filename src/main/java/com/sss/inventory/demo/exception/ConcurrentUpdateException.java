package com.sss.inventory.demo.exception;

public class ConcurrentUpdateException extends Exception{
    public ConcurrentUpdateException(String msg){
        super(msg);
    }
}
