package com.sx84.finance.platform.financex3.payment_plan.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("paymentPlanMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public PaymentPlanMapper paymentPlanMapper() {
        return new PaymentPlanMapper();
    }
}
