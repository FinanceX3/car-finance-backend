package com.sx84.finance.platform.financex3.financing.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class FinancingResource {
    private Long id;

    private float loan;

    private float initialFee;

    private float finalFee;

    private float balance;
}
