package com.sx84.finance.platform.financex3.financing.api;

import com.sx84.finance.platform.financex3.financing.domain.service.FinancingService;
import com.sx84.finance.platform.financex3.financing.mapping.FinancingMapper;
import com.sx84.finance.platform.financex3.financing.resource.FinancingResource;
import com.sx84.finance.platform.financex3.financing.resource.CreateFinancingResource;
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
@RequestMapping("/api/v1/financings")
@Tag(name = "Financings", description = "Create and read financings")
public class FinancingController {
    private final FinancingService financingService;
    private final FinancingMapper mapper;


    public FinancingController(FinancingService financingService, FinancingMapper mapper) {
        this.financingService = financingService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<FinancingResource> getAllFinancings(Pageable pageable){
        return mapper.modelListPage(financingService.getAll(), pageable);
    }

    @Operation(summary = "Get all financings")
    @GetMapping("{financingId}")
    public FinancingResource getFinancingById(@PathVariable Long financingId){
        return mapper.toResource(financingService.getById(financingId));
    }

    @Operation(summary = "Create financing", responses = {
            @ApiResponse(description = "Financing successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FinancingResource.class)))
    })
    @PostMapping
    public ResponseEntity<FinancingResource> createStudent(@RequestBody CreateFinancingResource resource) {
        return new ResponseEntity<>(mapper.toResource(financingService.create(resource)), HttpStatus.CREATED);
    }

}
