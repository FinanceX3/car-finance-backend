package com.sx84.finance.platform.financex3.payment_plan.resource;

import jakarta.validation.constraints.*;
import lombok.*;

import com.sx84.finance.platform.financex3.financing.domain.model.Financing;
import com.sx84.finance.platform.financex3.indicator.domain.model.Indicator;

@Getter
@Setter
public class UpdatePaymentPlanResource {
    private Long Id;

    @NotNull
    @NotBlank
    private String plan;

    @NotNull
    private float rate;

    @NotNull
    @NotBlank
    private String rateType;

    @NotNull
    private String grace_type;

    @NotNull
    private Integer grace;

    @NotNull
    private Indicator indicator;
    
    @NotNull
    private Financing financing;
}
