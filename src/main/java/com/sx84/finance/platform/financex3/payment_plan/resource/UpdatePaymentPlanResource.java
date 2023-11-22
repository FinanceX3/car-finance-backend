package com.sx84.finance.platform.financex3.payment_plan.resource;

import jakarta.validation.constraints.*;
import lombok.*;

import com.sx84.finance.platform.financex3.financing.domain.model.Financing;
import com.sx84.finance.platform.financex3.indicator.domain.model.Indicator;

import java.math.BigDecimal;

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
    private Indicator indicator;
    
    @NotNull
    private Financing financing;
}
