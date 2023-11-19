package com.sx84.finance.platform.financex3.indicator.service;

import com.sx84.finance.platform.financex3.indicator.domain.model.Indicator;
import com.sx84.finance.platform.financex3.indicator.domain.persistence.IndicatorRepository;
import com.sx84.finance.platform.financex3.indicator.domain.service.IndicatorService;
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
public class IndicatorServiceImpl implements IndicatorService {
    private static final String ENTITY = "Indicator";

    private final IndicatorRepository indicatorRepository;

    private final Validator validator;

    public IndicatorServiceImpl(IndicatorRepository indicatorRepository, Validator validator) {
        this.indicatorRepository = indicatorRepository;
        this.validator = validator;
    }

    @Override
    public List<Indicator> getAll() {
        return indicatorRepository.findAll();
    }

    @Override
    public Page<Indicator> getAll(Pageable pageable) {
        return indicatorRepository.findAll(pageable);
    }

    @Override
    public Indicator getById(Long indicatorId) {
        return indicatorRepository.findById(indicatorId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, indicatorId));
    }

    @Override
    public Indicator create(Indicator indicator) {
        Set<ConstraintViolation<Indicator>> violations = validator.validate(indicator);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return indicatorRepository.save(indicator);
    }
}
