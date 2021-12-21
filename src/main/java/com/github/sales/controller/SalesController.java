package com.github.sales.controller;

import com.github.sales.database.ProductRepository;
import com.github.sales.dto.Product;
import com.github.sales.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping(path = "/deals")
public class SalesController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/getProductDeal/{id}")
    public Product getDeal(@PathVariable int id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PutMapping("/claimDeal/{id}")
    public Product claimDeal(@PathVariable int id) throws ProductNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setQuantityOnSale(Math.max(product.getQuantityOnSale() - 1, 0));

        return productRepository.save(product);
    }

    @PutMapping("/endDeal/{id}")
    public Product endDeal(@PathVariable int id) throws ProductNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setEndTime(LocalDateTime.now());

        return productRepository.save(product);
    }

    @PutMapping("/updateDeal/{id}")
    public Product updateDeal(@PathVariable int id, @RequestParam int newQuantity) throws ProductNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setQuantityOnSale(newQuantity);

        return productRepository.save(product);
    }
}
