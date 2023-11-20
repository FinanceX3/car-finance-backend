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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "grace_type")
    @NotNull
    @NotBlank
    private String grace_type;

    @Column(name = "grace")
    @NotNull
    private Integer grace;

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
