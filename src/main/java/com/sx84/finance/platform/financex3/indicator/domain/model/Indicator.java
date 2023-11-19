package com.sx84.finance.platform.financex3.indicator.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "indicators")
public class Indicator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cok")
    @NotNull
    @NotBlank
    private float cok;

    @Column(name = "tir")
    @NotNull
    @NotBlank
    private float tir;

    @Column(name = "tcea")
    @NotNull
    @NotBlank
    private float tcea;

    @Column(name = "van")
    @NotNull
    @NotBlank
    private float van;

}
