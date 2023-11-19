package com.sx84.finance.platform.financex3.indicator.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sx84.finance.platform.financex3.indicator.domain.model.Indicator;

@Repository
public interface IndicatorRepository extends JpaRepository<Indicator, Long>{

}