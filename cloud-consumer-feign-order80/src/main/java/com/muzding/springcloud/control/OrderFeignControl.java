package com.muzding.springcloud.control;

import com.muzding.springcloud.entity.CommonResult;
import com.muzding.springcloud.entity.Payment;
import com.muzding.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lixiaolong
 * @date 2020/12/18 20:17
 */
@RestController
@RequestMapping("consumer")
@Slf4j
public class OrderFeignControl {
    @Resource
    private PaymentFeignService paymentFeignService;

    @RequestMapping(value = "/findPaymentByid",method = RequestMethod.GET)
    public CommonResult<Payment> getPaymentById(@RequestParam Long id) {
        return paymentFeignService.findPaymentByid(id);
    }

    @RequestMapping(value = "/payment/feign/timeout",method = RequestMethod.GET)
    public String paymentFeignTimeout() {
        // OpenFeign客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeOut();
    }


}
