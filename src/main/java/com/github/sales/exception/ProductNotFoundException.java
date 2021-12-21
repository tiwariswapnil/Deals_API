package com.github.sales.exception;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(int id) {
        super("Product " + id + " not found");
    }
}
