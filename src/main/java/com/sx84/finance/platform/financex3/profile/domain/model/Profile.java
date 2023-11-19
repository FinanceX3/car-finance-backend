package com.sx84.finance.platform.financex3.profile.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import com.sx84.finance.platform.financex3.user.domain.model.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "mother_last_name")
    @NotNull
    private String motherLastName;

    @Column(name = "father_last_name")
    @NotNull
    private String fatherLastName;

    @Column(name = "job")
    @NotNull
    private String job;

    @Column(name = "salary")
    @NotNull
    @DecimalMin(value = "0.01", inclusive = true)
    @DecimalMax(value = "999999999.99", inclusive = true)
    @Digits(integer = 9, fraction = 2)
    private BigDecimal salary;

    @Column(name = "dni")
    @NotNull
    @NotBlank
    private String dni;

    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
    private User user;
}
