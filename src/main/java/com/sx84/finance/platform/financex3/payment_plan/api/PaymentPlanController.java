package com.sx84.finance.platform.financex3.payment_plan.api;

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

import com.sx84.finance.platform.financex3.payment_plan.domain.service.PaymentPlanService;
import com.sx84.finance.platform.financex3.payment_plan.mapping.PaymentPlanMapper;
import com.sx84.finance.platform.financex3.payment_plan.resource.CreatePaymentPlanResource;
import com.sx84.finance.platform.financex3.payment_plan.resource.PaymentPlanResource;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/plans")
@Tag(name = "PaymentPlans", description = "Create and read paymentPlans")
public class PaymentPlanController {
    private final PaymentPlanService paymentPlanService;
    private final PaymentPlanMapper mapper;


    public PaymentPlanController(PaymentPlanService paymentPlanService, PaymentPlanMapper mapper) {
        this.paymentPlanService = paymentPlanService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<PaymentPlanResource> getAllPaymentPlans(Pageable pageable){
        return mapper.modelListPage(paymentPlanService.getAll(), pageable);
    }

    @Operation(summary = "Get all paymentPlans")
    @GetMapping("{paymentPlanId}")
    public PaymentPlanResource getPaymentPlanById(@PathVariable Long paymentPlanId){
        return mapper.toResource(paymentPlanService.getById(paymentPlanId));
    }

    @Operation(summary = "Create paymentPlan", responses = {
            @ApiResponse(description = "PaymentPlan successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentPlanResource.class)))
    })
    @PostMapping
    public ResponseEntity<PaymentPlanResource> createStudent(@RequestBody CreatePaymentPlanResource resource) {
        return new ResponseEntity<>(mapper.toResource(paymentPlanService.create(resource)), HttpStatus.CREATED);
    }

}
