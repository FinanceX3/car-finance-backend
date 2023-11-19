package com.sx84.finance.platform.financex3.financing.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sx84.finance.platform.financex3.financing.domain.model.Financing;

@Repository
public interface FinancingRepository extends JpaRepository<Financing, Long>{

}