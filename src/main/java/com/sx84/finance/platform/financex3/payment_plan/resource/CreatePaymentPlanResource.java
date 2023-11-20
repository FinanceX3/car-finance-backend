package com.sx84.finance.platform.financex3.payment_plan.resource;

import jakarta.validation.constraints.*;
import lombok.*;

import com.sx84.finance.platform.financex3.financing.resource.CreateFinancingResource;
import com.sx84.finance.platform.financex3.indicator.resource.CreateIndicatorResource;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentPlanResource {
    @NotNull
    @NotBlank
    private String plan;

    @NotNull
    private float rate;

    @NotNull
    @NotBlank
    private String rateType;

    @NotNull
    @NotBlank
    private String grace_type;

    @NotNull
    private Integer grace;

    @NotNull
    private CreateIndicatorResource indicator;
    
    @NotNull
    private CreateFinancingResource financing;

    @NotNull
    private Long user_id;
    
    @NotNull
    private Long car_id;
}
