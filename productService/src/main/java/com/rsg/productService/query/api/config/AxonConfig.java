package com.rsg.productService.query.api.config;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.queryhandling.DefaultQueryGateway;
import org.axonframework.queryhandling.QueryBus;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SimpleQueryBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    @Bean
    public QueryGateway queryGateway(QueryBus queryBus) {
        return DefaultQueryGateway.
                builder()
                .queryBus(queryBus)
                .build();
    }

    @Bean
    public QueryBus queryBus() {
        return SimpleQueryBus.builder().build();
    }
}
