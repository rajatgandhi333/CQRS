package com.rsg.productService.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCreationEvent {

    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
