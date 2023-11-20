package com.sx84.finance.platform.financex3.payment_plan.service;

import com.sx84.finance.platform.financex3.car.domain.model.Car;
import com.sx84.finance.platform.financex3.car.domain.service.CarService;
import com.sx84.finance.platform.financex3.payment_plan.domain.model.PaymentPlan;
import com.sx84.finance.platform.financex3.payment_plan.domain.persistence.PaymentPlanRepository;
import com.sx84.finance.platform.financex3.payment_plan.domain.service.PaymentPlanService;
import com.sx84.finance.platform.financex3.payment_plan.mapping.PaymentPlanMapper;
import com.sx84.finance.platform.financex3.payment_plan.resource.CreatePaymentPlanResource;
import com.sx84.finance.platform.financex3.shared.exception.ResourceNotFoundException;
import com.sx84.finance.platform.financex3.shared.exception.ResourceValidationException;
import com.sx84.finance.platform.financex3.user.domain.model.User;
import com.sx84.finance.platform.financex3.user.domain.service.UserService;

import jakarta.validation.ConstraintViolation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import jakarta.validation.Validator;

import java.util.List;
import java.util.Set;

@Service
public class PaymentPlanServiceImpl implements PaymentPlanService {
    private static final String ENTITY = "PaymentPlan";

    private final PaymentPlanRepository paymentPlanRepository;

    private final PaymentPlanMapper mapper;

    private final UserService userService;
    private final CarService carService;

    private final Validator validator;

    public PaymentPlanServiceImpl(
        PaymentPlanRepository paymentPlanRepository, 
        UserService userService, 
        Validator validator, 
        CarService carService,
        PaymentPlanMapper mapper
        ) {
        this.paymentPlanRepository = paymentPlanRepository;
        this.mapper = mapper;
        this.userService = userService;
        this.carService = carService;
        this.validator = validator;
    }

    @Override
    public List<PaymentPlan> getAll() {
        return paymentPlanRepository.findAll();
    }

    @Override
    public Page<PaymentPlan> getAll(Pageable pageable) {
        return paymentPlanRepository.findAll(pageable);
    }

    @Override
    public PaymentPlan getById(Long paymentPlanId) {
        return paymentPlanRepository.findById(paymentPlanId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, paymentPlanId));
    }

    @Override
    public PaymentPlan create(CreatePaymentPlanResource resource) {
        Set<ConstraintViolation<CreatePaymentPlanResource>> violations = validator.validate(resource);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        //validation of user and car

        User existingUser = userService.getById(resource.getUser_id());
        if (existingUser == null)
            throw new ResourceValidationException(ENTITY, "The user" + resource.getUser_id() + "doesn't exists");
        
        Car existingCar = carService.getById(resource.getCar_id());
        if (existingCar == null)
            throw new ResourceValidationException(ENTITY, "This car doesn't exists");
            
        PaymentPlan newPaymentPlan = paymentPlanRepository.save(mapper.toModel(resource));

        return newPaymentPlan;
    }
}
