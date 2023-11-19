package com.sx84.finance.platform.financex3.indicator.api;

import com.sx84.finance.platform.financex3.indicator.domain.service.IndicatorService;
import com.sx84.finance.platform.financex3.indicator.mapping.IndicatorMapper;
import com.sx84.finance.platform.financex3.indicator.resource.IndicatorResource;
import com.sx84.finance.platform.financex3.indicator.resource.CreateIndicatorResource;
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
@RequestMapping("/api/v1/Indicators")
@Tag(name = "Indicators", description = "Create and read Indicators")
public class IndicatorController {
    private final IndicatorService IndicatorService;
    private final IndicatorMapper mapper;


    public IndicatorController(IndicatorService IndicatorService, IndicatorMapper mapper) {
        this.IndicatorService = IndicatorService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<IndicatorResource> getAllIndicators(Pageable pageable){
        return mapper.modelListPage(IndicatorService.getAll(), pageable);
    }

    @Operation(summary = "Get all Indicators")
    @GetMapping("{IndicatorId}")
    public IndicatorResource getIndicatorById(@PathVariable Long IndicatorId){
        return mapper.toResource(IndicatorService.getById(IndicatorId));
    }

    @Operation(summary = "Create Indicator", responses = {
            @ApiResponse(description = "Indicator successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = IndicatorResource.class)))
    })
    @PostMapping
    public ResponseEntity<IndicatorResource> createStudent(@RequestBody CreateIndicatorResource resource) {
        return new ResponseEntity<>(mapper.toResource(IndicatorService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

}
