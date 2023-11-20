package com.sx84.finance.platform.financex3.indicator.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sx84.finance.platform.financex3.indicator.domain.model.Indicator;
import com.sx84.finance.platform.financex3.indicator.resource.CreateIndicatorResource;

public interface IndicatorService {
    List<Indicator> getAll();
    Page<Indicator> getAll(Pageable pageable);

    Indicator getById(Long id);
    Indicator create(CreateIndicatorResource resource);
}
