package com.sx84.finance.platform.financex3.car.resource;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CarResource {
    private Long Id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private BigDecimal price;
    private String imageUrl;
}
