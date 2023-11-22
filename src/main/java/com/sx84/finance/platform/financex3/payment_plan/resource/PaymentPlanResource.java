package com.sx84.finance.platform.financex3.payment_plan.resource;

import lombok.*;

import com.sx84.finance.platform.financex3.financing.domain.model.Financing;
import com.sx84.finance.platform.financex3.indicator.domain.model.Indicator;

import java.math.BigDecimal;

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

    private String graceTypeTotal;

    private Integer graceTypePartial;

    private BigDecimal initialFee;

    private BigDecimal finalInstallment;

    private Integer term;

    private BigDecimal discountRate;

    private String capitalizationPeriod;

    private Integer paymentFrequency;

    private Integer daysYear;

    private BigDecimal notarialCosts;

    private String notarialCostType;

    private BigDecimal registrationCosts;

    private String registrationCostType;

    private BigDecimal appraisal;

    private String appraisalType;

    private BigDecimal studyCommission;

    private String studyCommissionType;

    private BigDecimal activationCommission;

    private String activationCommissionType;

    private BigDecimal gps;

    private BigDecimal portage;

    private BigDecimal administrationExpenses;

    private Indicator indicator;
    
    private Financing financing;
}
