package com.sx84.finance.platform.financex3.financing.service;

import com.sx84.finance.platform.financex3.financing.domain.model.Financing;
import com.sx84.finance.platform.financex3.financing.domain.persistence.FinancingRepository;
import com.sx84.finance.platform.financex3.financing.domain.service.FinancingService;
import com.sx84.finance.platform.financex3.financing.mapping.FinancingMapper;
import com.sx84.finance.platform.financex3.financing.resource.CreateFinancingResource;
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
public class FinancingServiceImpl implements FinancingService {
    private static final String ENTITY = "Financing";

    private final FinancingRepository financingRepository;
    private final FinancingMapper mapper;

    private final Validator validator;

    public FinancingServiceImpl(FinancingRepository financingRepository, FinancingMapper mapper, Validator validator) {
        this.financingRepository = financingRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public List<Financing> getAll() {
        return financingRepository.findAll();
    }

    @Override
    public Page<Financing> getAll(Pageable pageable) {
        return financingRepository.findAll(pageable);
    }

    @Override
    public Financing getById(Long financingId) {
        return financingRepository.findById(financingId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, financingId));
    }

    @Override
    public Financing create(CreateFinancingResource resource) {
        Set<ConstraintViolation<CreateFinancingResource>> violations = validator.validate(resource);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return financingRepository.save(mapper.toModel(resource));
    }
}
