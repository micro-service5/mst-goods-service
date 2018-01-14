package com.thoughtworks.mstorderservice.exception;

public class GoodsNotFoundException extends RuntimeException{

    public GoodsNotFoundException(Long id){
        super("Goods not found by id :" + id);
    }
}
