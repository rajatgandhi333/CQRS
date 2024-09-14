package com.rsg.productService.command.api.aggregate;

import com.rsg.productService.command.api.command.CreateProductCommand;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public ProductAggregate(){

    }

    public ProductAggregate(CreateProductCommand createProductCommand){

    }
}
