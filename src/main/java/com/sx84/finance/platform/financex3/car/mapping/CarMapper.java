package com.sx84.finance.platform.financex3.car.mapping;

import com.sx84.finance.platform.financex3.car.domain.model.Car;
import com.sx84.finance.platform.financex3.car.resource.CarResource;
import com.sx84.finance.platform.financex3.car.resource.CreateCarResource;
import com.sx84.finance.platform.financex3.car.resource.UpdateCarResource;
import com.sx84.finance.platform.financex3.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class CarMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public CarResource toResource(Car model) {
        return mapper.map(model, CarResource.class);
    }

    public Car toModel(CreateCarResource resource) {
        return mapper.map(resource, Car.class);
    }

    public Car toModel(UpdateCarResource resource) {
        return mapper.map(resource, Car.class);
    }

    public Page<CarResource> modelListPage(List<Car> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, CarResource.class), pageable, modelList.size());
    }
}
