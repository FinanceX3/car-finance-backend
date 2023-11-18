package com.sx84.finance.platform.financex3.car.resource;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarResource {
    @NotNull
    @NotBlank
    private String brand;

    @NotNull
    @NotBlank
    private String model;

    @Min(1980)
    private int year;

    @NotNull
    @NotBlank
    private String color;

    @NotNull
    @DecimalMin(value = "0.01", inclusive = true)
    @DecimalMax(value = "999999999.99", inclusive = true)
    @Digits(integer = 9, fraction = 2)
    private BigDecimal price;

    @NotNull
    @NotBlank
    private String imageUrl;
}
