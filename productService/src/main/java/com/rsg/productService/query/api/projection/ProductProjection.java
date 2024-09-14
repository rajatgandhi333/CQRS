package com.rsg.productService.query.api.projection;

import com.rsg.productService.command.api.entiity.Product;
import com.rsg.productService.command.api.model.ProductModel;
import com.rsg.productService.command.api.repository.ProductRepository;
import com.rsg.productService.query.api.queries.FindAllProductsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    @Autowired
    private ProductRepository productRepository;

    @QueryHandler
    public List<ProductModel> handle(FindAllProductsQuery findAllProductsQuery) {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(product -> ProductModel.builder().
                        name(product.getName())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .build())
                .collect(Collectors.toList());
    }

}
