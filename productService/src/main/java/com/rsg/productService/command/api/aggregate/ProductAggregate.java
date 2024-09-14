package com.rsg.productService.command.api.aggregate;

import com.rsg.productService.command.api.command.CreateProductCommand;
import com.rsg.productService.command.api.events.ProductCreationEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    //for each command, we need  a handler
    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {
        ProductCreationEvent productCreationEvent = new ProductCreationEvent();
        BeanUtils.copyProperties(createProductCommand, productCreationEvent);
        AggregateLifecycle.apply(productCreationEvent);

    }

    //to handle the command,we have an event handler
    @EventSourcingHandler
    public void on(ProductCreationEvent productCreationEvent) {
        this.productId = productCreationEvent.getProductId();
        this.name = productCreationEvent.getName();
        this.price = productCreationEvent.getPrice();
        this.quantity = productCreationEvent.getQuantity();
    }
}
