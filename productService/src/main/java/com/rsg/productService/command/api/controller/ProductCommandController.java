package com.rsg.productService.command.api.controller;


import com.rsg.productService.command.api.command.CreateProductCommand;
import com.rsg.productService.command.api.model.ProductModel;
import com.rsg.productService.command.api.utility.Utility;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.rsg.productService.command.api.utility.Constant.PRODUCT_ADDED;
import static com.rsg.productService.command.api.utility.Constant.PRODUCT_COMMAND_API;

@RestController
@RequestMapping(PRODUCT_COMMAND_API)
public class ProductCommandController {

    private final CommandGateway commandGateway;

    public ProductCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }


    @PostMapping
    public String addProduct(@RequestBody ProductModel productModel) {
        CreateProductCommand createProductCommand = Utility.mapToProductCommand(productModel);


        return PRODUCT_ADDED;
    }
}
