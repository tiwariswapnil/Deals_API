package com.github.sales.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue
    public int id;
    public String name;
    public int totalQuantity;
    public int price;
    public int priceOnSale;
    public int quantityOnSale;
    public LocalDateTime startTime;
    public LocalDateTime endTime;

}
