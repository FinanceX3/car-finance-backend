package com.sx84.finance.platform.financex3.user.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UserResource {
    private Long id;
    private String email;
    private String password;
}
