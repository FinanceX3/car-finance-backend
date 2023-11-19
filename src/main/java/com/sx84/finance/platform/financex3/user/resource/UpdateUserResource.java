package com.sx84.finance.platform.financex3.user.resource;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class UpdateUserResource {
    private Long id;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String password;
}
