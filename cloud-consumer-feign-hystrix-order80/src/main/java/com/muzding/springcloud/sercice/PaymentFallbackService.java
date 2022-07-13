package com.muzding.springcloud.sercice;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOK(Integer id) {
        return " -----PaymentFallbackService paymentInfoOK ";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return " -----PaymentFallbackService paymentInfoTimeout ";
    }
}
