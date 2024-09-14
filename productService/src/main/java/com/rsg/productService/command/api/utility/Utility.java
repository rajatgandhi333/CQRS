package com.rsg.productService.command.api.utility;

import com.rsg.productService.command.api.command.CreateProductCommand;
import com.rsg.productService.command.api.model.ProductModel;

import java.util.UUID;

public class Utility {

    public static CreateProductCommand mapToProductCommand(ProductModel model) {
        return CreateProductCommand.
                builder().
                productId(UUID.randomUUID().toString())
                .price(model.getPrice())
                .name(model.getName())
                .quantity(model.getQuantity())
                .build();
    }

}
