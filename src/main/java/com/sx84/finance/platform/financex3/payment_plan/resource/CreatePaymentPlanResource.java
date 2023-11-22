package com.sx84.finance.platform.financex3.payment_plan.resource;

import jakarta.validation.constraints.*;
import lombok.*;

import com.sx84.finance.platform.financex3.financing.resource.CreateFinancingResource;
import com.sx84.finance.platform.financex3.indicator.resource.CreateIndicatorResource;

import java.math.BigDecimal;

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
    private String graceTypeTotal;

    @NotNull
    private Integer graceTypePartial;

    @NotNull
    private BigDecimal initialFee;

    @NotNull
    private BigDecimal finalInstallment;

    @NotNull
    private Integer term;

    @NotNull
    private BigDecimal discountRate;

    @NotNull
    @NotBlank
    private String capitalizationPeriod;

    @NotNull
    private Integer paymentFrequency;

    @NotNull
    private Integer daysYear;

    @NotNull
    private BigDecimal notarialCosts;

    @NotNull
    @NotBlank
    private String notarialCostType;

    @NotNull
    private BigDecimal registrationCosts;

    @NotNull
    @NotBlank
    private String registrationCostType;

    @NotNull
    private BigDecimal appraisal;

    @NotNull
    @NotBlank
    private String appraisalType;

    @NotNull
    private BigDecimal studyCommission;

    @NotNull
    @NotBlank
    private String studyCommissionType;

    @NotNull
    private BigDecimal activationCommission;

    @NotNull
    @NotBlank
    private String activationCommissionType;

    @NotNull
    private BigDecimal gps;

    @NotNull
    private BigDecimal portage;

    @NotNull
    private BigDecimal administrationExpenses;

    @NotNull
    private CreateIndicatorResource indicator;
    
    @NotNull
    private CreateFinancingResource financing;

    @NotNull
    private Long user_id;
    
    @NotNull
    private Long car_id;
}
