package com.sx84.finance.platform.financex3.car.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("carMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public CarMapper carMapper() {
        return new CarMapper();
    }
}
