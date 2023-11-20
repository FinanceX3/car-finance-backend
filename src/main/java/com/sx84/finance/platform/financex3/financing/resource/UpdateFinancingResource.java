package com.sx84.finance.platform.financex3.financing.resource;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class UpdateFinancingResource {
    private Long Id;

    @NotNull
    private float loan;

    @NotNull
    private BigDecimal initialFee;

    @NotNull
    private BigDecimal finalFee;

    @NotNull
    private BigDecimal balance;
}
