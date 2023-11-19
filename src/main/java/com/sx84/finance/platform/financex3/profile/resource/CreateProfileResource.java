package com.sx84.finance.platform.financex3.profile.resource;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateProfileResource {
    @NotNull
    private String name;

    @NotNull
    private String motherLastName;

    @NotNull
    private String fatherLastName;

    @NotNull
    private String job;

    @NotNull
    @DecimalMin(value = "0.01", inclusive = true)
    @DecimalMax(value = "999999999.99", inclusive = true)
    @Digits(integer = 9, fraction = 2)
    private BigDecimal salary;

    @NotNull
    @NotBlank
    private String dni;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String password;
}
