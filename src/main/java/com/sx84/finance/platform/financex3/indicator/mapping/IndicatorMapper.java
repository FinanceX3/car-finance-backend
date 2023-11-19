package com.sx84.finance.platform.financex3.indicator.mapping;

import com.sx84.finance.platform.financex3.indicator.domain.model.Indicator;
import com.sx84.finance.platform.financex3.indicator.resource.IndicatorResource;
import com.sx84.finance.platform.financex3.indicator.resource.CreateIndicatorResource;
import com.sx84.finance.platform.financex3.indicator.resource.UpdateIndicatorResource;
import com.sx84.finance.platform.financex3.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class IndicatorMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public IndicatorResource toResource(Indicator model) {
        return mapper.map(model, IndicatorResource.class);
    }

    public Indicator toModel(CreateIndicatorResource resource) {
        return mapper.map(resource, Indicator.class);
    }

    public Indicator toModel(UpdateIndicatorResource resource) {
        return mapper.map(resource, Indicator.class);
    }

    public Page<IndicatorResource> modelListPage(List<Indicator> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, IndicatorResource.class), pageable, modelList.size());
    }
}
