package com.sx84.finance.platform.financex3.financing.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sx84.finance.platform.financex3.financing.domain.model.Financing;
import com.sx84.finance.platform.financex3.financing.resource.CreateFinancingResource;

public interface FinancingService {
    List<Financing> getAll();
    Page<Financing> getAll(Pageable pageable);

    Financing getById(Long id);
    Financing create(CreateFinancingResource resource);
}
