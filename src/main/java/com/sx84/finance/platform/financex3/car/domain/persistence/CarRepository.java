package com.sx84.finance.platform.financex3.car.domain.persistence;

import com.sx84.finance.platform.financex3.car.domain.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByBrand(String brand);
    Car findByModelAndBrand(String model, String brand);
}
