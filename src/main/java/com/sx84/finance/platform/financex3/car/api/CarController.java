package com.sx84.finance.platform.financex3.car.api;

import com.sx84.finance.platform.financex3.car.domain.model.Car;
import com.sx84.finance.platform.financex3.car.domain.service.CarService;
import com.sx84.finance.platform.financex3.car.mapping.CarMapper;
import com.sx84.finance.platform.financex3.car.resource.CarResource;
import com.sx84.finance.platform.financex3.car.resource.CreateCarResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cars")
@Tag(name = "Cars", description = "Create and read cars")
public class CarController {
    private final CarService carService;
    private final CarMapper mapper;


    public CarController(CarService carService, CarMapper mapper) {
        this.carService = carService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<CarResource> getAllCars(Pageable pageable){
        return mapper.modelListPage(carService.getAll(), pageable);
    }

    @Operation(summary = "Get all cars")
    @GetMapping("{carId}")
    public CarResource getCarById(@PathVariable Long carId){
        return mapper.toResource(carService.getById(carId));
    }

    @Operation(summary = "Create car", responses = {
            @ApiResponse(description = "Car successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarResource.class)))
    })
    @PostMapping
    public ResponseEntity<CarResource> createStudent(@RequestBody CreateCarResource resource) {
        return new ResponseEntity<>(mapper.toResource(carService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

}
