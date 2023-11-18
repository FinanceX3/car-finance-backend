package com.sx84.finance.platform.financex3.car.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public CarMapper studentMapper() {
        return new CarMapper();
    }
}
