package com.sx84.finance.platform.financex3.car.service;

import com.sx84.finance.platform.financex3.car.domain.model.Car;
import com.sx84.finance.platform.financex3.car.domain.persistence.CarRepository;
import com.sx84.finance.platform.financex3.car.domain.service.CarService;
import com.sx84.finance.platform.financex3.shared.exception.ResourceNotFoundException;
import com.sx84.finance.platform.financex3.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import jakarta.validation.Validator;

import java.util.List;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService {
    private static final String ENTITY = "Car";

    private final CarRepository carRepository;

    private final Validator validator;

    public CarServiceImpl(CarRepository carRepository, Validator validator) {
        this.carRepository = carRepository;
        this.validator = validator;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Page<Car> getAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    @Override
    public Car getById(Long carId) {
        return carRepository.findById(carId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, carId));
    }

    @Override
    public Car create(Car car) {
        Set<ConstraintViolation<Car>> violations = validator.validate(car);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        //validation of brand and model

        Car carWithBrandAndModel = carRepository.findByModelAndBrand(car.getModel(), car.getBrand());

        if (carWithBrandAndModel != null)
            throw new ResourceValidationException(ENTITY, "An car with the same brand and model already exists.");

        return carRepository.save(car);
    }
}
