package com.sx84.finance.platform.financex3.payment_plan.domain.model;

import com.sx84.finance.platform.financex3.car.domain.model.Car;
import com.sx84.finance.platform.financex3.financing.domain.model.Financing;
import com.sx84.finance.platform.financex3.indicator.domain.model.Indicator;
import com.sx84.finance.platform.financex3.user.domain.model.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_plans")
public class PaymentPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plan")
    @NotNull
    @NotBlank
    private String plan;

    @Column(name = "rate")
    @NotNull
    private float rate;

    @Column(name = "rate_type")
    @NotNull
    @NotBlank
    private String rateType;

    @Column(name = "grace_type_total")
    @NotNull
    @NotBlank
    private String graceTypeTotal;

    @Column(name = "grace_type_partial")
    @NotNull
    private Integer graceTypePartial;

    @Column(name = "initial_fee")
    @DecimalMin(value = "0.00", inclusive = true)
    @DecimalMax(value = "999999999.99", inclusive = true)
    @NotNull
    private BigDecimal initialFee;

    @Column(name = "final_stallment")
    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    @DecimalMax(value = "999999999.99", inclusive = true)
    private BigDecimal finalInstallment;

    @Column(name = "term")
    @NotNull
    private Integer term;

    @Column(name = "discount_rate")
    @DecimalMin(value = "0.00", inclusive = true)
    @NotNull
    private BigDecimal discountRate;

    @Column(name = "capitalization_period")
    @NotNull
    @NotBlank
    private String capitalizationPeriod;

    @Column(name = "payment_frequency")
    @NotNull
    private Integer paymentFrequency;

    @Column(name = "days_year")
    @NotNull
    private Integer daysYear;

    @Column(name = "notarial_costs")
    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    private BigDecimal notarialCosts;

    @Column(name = "notarial_cost_type")
    @NotNull
    @NotBlank
    private String notarialCostType;

    @Column(name = "registration_costs")
    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    private BigDecimal registrationCosts;

    @Column(name = "registration_cost_type")
    @NotNull
    @NotBlank
    private String registrationCostType;

    @Column(name = "appraisal")
    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    private BigDecimal appraisal;

    @Column(name = "appraisal_type")
    @NotNull
    @NotBlank
    private String appraisalType;

    @Column(name = "study_commission")
    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    private BigDecimal studyCommission;

    @Column(name = "study_commission_type")
    @NotNull
    @NotBlank
    private String studyCommissionType;

    @Column(name = "activation_commission")
    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    private BigDecimal activationCommission;

    @Column(name = "activation_commission_type")
    @NotNull
    @NotBlank
    private String activationCommissionType;

    @Column(name = "gps")
    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    private BigDecimal gps;

    @Column(name = "portage")
    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    private BigDecimal portage;

    @Column(name = "administration_expenses")
    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    private BigDecimal administrationExpenses;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "indicator_id")
    private Indicator indicator;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "financing_id")
    private Financing financing;
}
