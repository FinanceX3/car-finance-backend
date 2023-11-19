package com.sx84.finance.platform.financex3.indicator.resource;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateIndicatorResource {
    @NotNull
    @NotBlank
    private float cok;

    @NotNull
    @NotBlank
    private float tir;

    @NotNull
    @NotBlank
    private float tcea;

    @NotNull
    @NotBlank
    private float van;
}
