package com.sx84.finance.platform.financex3.user.domain.model;


import java.util.List;

import com.sx84.finance.platform.financex3.payment_plan.domain.model.PaymentPlan;
import com.sx84.finance.platform.financex3.profile.domain.model.Profile;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @OneToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @OneToMany(mappedBy = "user")
    private List<PaymentPlan> paymentPlans;
}
