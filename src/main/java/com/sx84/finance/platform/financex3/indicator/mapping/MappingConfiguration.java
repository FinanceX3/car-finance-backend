package com.sx84.finance.platform.financex3.indicator.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("indicatorMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public IndicatorMapper indicatorMapper() {
        return new IndicatorMapper();
    }
}
