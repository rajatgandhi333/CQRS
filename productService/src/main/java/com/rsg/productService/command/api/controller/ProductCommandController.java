package com.rsg.productService.command.api.controller;


import com.rsg.productService.command.api.command.CreateProductCommand;
import com.rsg.productService.command.api.model.ProductModel;
import com.rsg.productService.command.api.utility.Utility;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.rsg.productService.command.api.utility.Constant.*;

@RestController
@RequestMapping(PRODUCT_COMMAND_API)
public class ProductCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping(ADD_PRODUCT)
    public String addProduct(@RequestBody ProductModel productModel) {
        CreateProductCommand createProductCommand = Utility.mapToProductCommand(productModel);
        String result = commandGateway.sendAndWait(createProductCommand);
        return result;
    }
}
