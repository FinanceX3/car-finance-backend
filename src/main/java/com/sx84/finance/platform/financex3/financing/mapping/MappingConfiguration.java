package com.sx84.finance.platform.financex3.financing.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("financingMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public FinancingMapper financingMapper() {
        return new FinancingMapper();
    }
}
