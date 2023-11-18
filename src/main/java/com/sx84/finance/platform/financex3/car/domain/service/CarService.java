package com.sx84.finance.platform.financex3.car.domain.service;


import com.sx84.finance.platform.financex3.car.domain.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarService {
    List<Car> getAll();
    Page<Car> getAll(Pageable pageable);

    Car getById(Long carId);
    Car create(Car car);
}
