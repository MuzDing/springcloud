package com.muzding.springcloud.service;

import com.muzding.springcloud.entity.CommonResult;
import com.muzding.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL")
    CommonResult<Payment> paymentSQL(@RequestParam("id") Long id);
}
