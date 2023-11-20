package com.sx84.finance.platform.financex3.financing.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "financings")
public class Financing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loan")
    @NotNull
    private float loan;

    @Column(name = "initial_fee")
    @NotNull
    private BigDecimal initialFee;

    @Column(name = "final_fee")
    @NotNull
    private BigDecimal finalFee;

    @Column(name = "balance")
    @NotNull
    private BigDecimal balance;

}
