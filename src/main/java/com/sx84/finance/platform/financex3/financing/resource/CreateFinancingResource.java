package com.sx84.finance.platform.financex3.financing.resource;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateFinancingResource {
    @NotNull
    @NotBlank
    private float loan;

    @NotNull
    @NotBlank
    private float initial_fee;

    @NotNull
    @NotBlank
    private float final_fee;

    @NotNull
    @NotBlank
    private float balance;
}
