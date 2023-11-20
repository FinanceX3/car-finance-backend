package com.sx84.finance.platform.financex3.payment_plan.resource;

import lombok.*;

import com.sx84.finance.platform.financex3.financing.domain.model.Financing;
import com.sx84.finance.platform.financex3.indicator.domain.model.Indicator;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class PaymentPlanResource {
    private Long id;

    private String plan;

    private float rate;

    private String rateType;

    private String grace_type;

    private Integer grace;

    private Indicator indicator;
    
    private Financing financing;
}
