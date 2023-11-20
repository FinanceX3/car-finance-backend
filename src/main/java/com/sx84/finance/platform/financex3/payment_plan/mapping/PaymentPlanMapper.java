package com.sx84.finance.platform.financex3.payment_plan.mapping;

import com.sx84.finance.platform.financex3.car.domain.persistence.CarRepository;
import com.sx84.finance.platform.financex3.financing.mapping.FinancingMapper;
import com.sx84.finance.platform.financex3.indicator.mapping.IndicatorMapper;
import com.sx84.finance.platform.financex3.payment_plan.domain.model.PaymentPlan;
import com.sx84.finance.platform.financex3.payment_plan.resource.CreatePaymentPlanResource;
import com.sx84.finance.platform.financex3.payment_plan.resource.PaymentPlanResource;
import com.sx84.finance.platform.financex3.payment_plan.resource.UpdatePaymentPlanResource;
import com.sx84.finance.platform.financex3.shared.mapping.EnhancedModelMapper;
import com.sx84.finance.platform.financex3.user.domain.persistence.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class PaymentPlanMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    @Autowired
    private FinancingMapper financingMapper;

    @Autowired
    private IndicatorMapper indicatorMapper;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    public PaymentPlanResource toResource(PaymentPlan model) {
        return mapper.map(model, PaymentPlanResource.class);
    }

    public PaymentPlan toModel(CreatePaymentPlanResource resource) {
        PaymentPlan plan = mapper.map(resource, PaymentPlan.class);
        plan.setFinancing(financingMapper.toModel(resource.getFinancing()));
        plan.setIndicator(indicatorMapper.toModel(resource.getIndicator()));
        plan.setCar(carRepository.findById(resource.getCar_id()).orElse(null));
        plan.setUser(userRepository.findById(resource.getUser_id()).orElse(null));
        return plan;
    }

    public PaymentPlan toModel(UpdatePaymentPlanResource resource) {
        return mapper.map(resource, PaymentPlan.class);
    }

    public Page<PaymentPlanResource> modelListPage(List<PaymentPlan> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PaymentPlanResource.class), pageable, modelList.size());
    }
}
