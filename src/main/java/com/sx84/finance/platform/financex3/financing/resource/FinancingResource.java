package com.sx84.finance.platform.financex3.financing.resource;

import java.math.BigDecimal;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class FinancingResource {
    private Long id;

    private float loan;

    private BigDecimal initialFee;

    private BigDecimal finalFee;

    private BigDecimal balance;
}
