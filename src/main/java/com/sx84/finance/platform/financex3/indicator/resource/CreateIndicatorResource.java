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
    private float cok;

    @NotNull
    private float tir;

    @NotNull
    private float tcea;

    @NotNull
    private float van;
}
