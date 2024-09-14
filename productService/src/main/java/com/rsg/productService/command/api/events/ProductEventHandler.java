package com.rsg.productService.command.api.events;


import com.rsg.productService.command.api.entiity.Product;
import com.rsg.productService.command.api.repository.ProductRepository;
import lombok.extern.java.Log;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.logging.Logger;

import static com.rsg.productService.command.api.utility.Constant.GENERIC_EXCEPTION;
import static com.rsg.productService.command.api.utility.Constant.PROCESSING_GROUP_PRODUCT;

@Component
@ProcessingGroup(PROCESSING_GROUP_PRODUCT)
public class ProductEventHandler {

    private ProductRepository productRepository;

    private static final Logger log = Logger.getLogger(ProductEventHandler.class.getName());

    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    //save the product
    //create an event of product being created
    @EventHandler
    public void on(ProductCreationEvent productCreationEvent) {
        Product product = new Product();
        BeanUtils.copyProperties(productCreationEvent, product);
        productRepository.save(product);
        log.info("product is saved");
    }
}
