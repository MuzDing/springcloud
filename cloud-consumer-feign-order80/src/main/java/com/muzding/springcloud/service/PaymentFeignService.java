package com.muzding.springcloud.service;


import com.muzding.springcloud.entity.CommonResult;
import com.muzding.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author muzding
 * @date 2022-07-12
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @RequestMapping(value = "/findPaymentByid",method = RequestMethod.GET)
    CommonResult<Payment> findPaymentByid(@RequestParam("id") Long id);

    @RequestMapping(value = "/payment/feign/timeout",method = RequestMethod.GET)
    public String paymentFeignTimeOut();
}
