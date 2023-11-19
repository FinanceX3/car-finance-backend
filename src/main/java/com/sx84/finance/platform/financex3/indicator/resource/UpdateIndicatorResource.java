package com.sx84.finance.platform.financex3.indicator.resource;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class UpdateIndicatorResource {
    private Long Id;

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
