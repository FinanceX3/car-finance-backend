package com.sx84.finance.platform.financex3.payment_plan.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sx84.finance.platform.financex3.payment_plan.domain.model.PaymentPlan;
import com.sx84.finance.platform.financex3.payment_plan.resource.CreatePaymentPlanResource;


public interface PaymentPlanService {
    List<PaymentPlan> getAll();
    Page<PaymentPlan> getAll(Pageable pageable);

    PaymentPlan getById(Long id);
    PaymentPlan create(CreatePaymentPlanResource resource);
}
