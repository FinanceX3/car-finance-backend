package com.sx84.finance.platform.financex3.payment_plan.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sx84.finance.platform.financex3.payment_plan.domain.model.PaymentPlan;

@Repository
public interface PaymentPlanRepository extends JpaRepository<PaymentPlan, Long>{

}