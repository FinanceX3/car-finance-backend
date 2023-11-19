package com.sx84.finance.platform.financex3.financing.mapping;

import com.sx84.finance.platform.financex3.financing.domain.model.Financing;
import com.sx84.finance.platform.financex3.financing.resource.FinancingResource;
import com.sx84.finance.platform.financex3.financing.resource.CreateFinancingResource;
import com.sx84.finance.platform.financex3.financing.resource.UpdateFinancingResource;
import com.sx84.finance.platform.financex3.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class FinancingMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public FinancingResource toResource(Financing model) {
        return mapper.map(model, FinancingResource.class);
    }

    public Financing toModel(CreateFinancingResource resource) {
        return mapper.map(resource, Financing.class);
    }

    public Financing toModel(UpdateFinancingResource resource) {
        return mapper.map(resource, Financing.class);
    }

    public Page<FinancingResource> modelListPage(List<Financing> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, FinancingResource.class), pageable, modelList.size());
    }
}
