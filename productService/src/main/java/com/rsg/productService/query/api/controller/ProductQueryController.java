package com.rsg.productService.query.api.controller;

import com.rsg.productService.command.api.entiity.Product;
import com.rsg.productService.command.api.model.ProductModel;
import com.rsg.productService.command.api.utility.Constant;
import com.rsg.productService.query.api.queries.FindAllProductsQuery;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Constant.PRODUCT_COMMAND_API)
public class ProductQueryController {

    @Autowired
    private QueryGateway queryGateway;

    //add a core module to seperate all common classes
    @GetMapping("/getAllProducts")
    public List<ProductModel> getAllProduct() {
        FindAllProductsQuery findAllProductsQuery = new FindAllProductsQuery();
        var productModelList = queryGateway.query(findAllProductsQuery, ResponseTypes.multipleInstancesOf(ProductModel.class))
                .join();
        return productModelList;
    }

}
