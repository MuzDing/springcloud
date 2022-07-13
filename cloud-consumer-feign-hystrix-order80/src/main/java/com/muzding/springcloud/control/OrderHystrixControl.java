package com.muzding.springcloud.control;


import com.muzding.springcloud.sercice.PaymentHystrixService;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;


/**
 * @author muzding
 */
@RestController
@RequestMapping("consumer")
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")// hystrix 全局fallback方法

public class OrderHystrixControl {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok")
    public String paymentInfoOK(@RequestParam Integer id) {
        String result = paymentHystrixService.paymentInfoOK(id);
        return result;
    }


    @GetMapping("/payment/hystrix/timeout")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
//    })
//    @HystrixCommand
    public String paymentInfoTimeOut(@RequestParam Integer id) {
        int age = 10 / 0;
        String result = paymentHystrixService.paymentInfoTimeout(id);
        return result;
    }

    /**
     * 超时访问，设置自身调用超时的峰值，峰值内正常运行，超过了峰值需要服务降级 自动调用fallbackMethod 指定的方法
     * <br/>
     * 超时异常或者运行异常 都会进行服务降级
     *
     * @param id
     * @return
     */
    public String paymentTimeOutFallbackMethod(@RequestParam Integer id) {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    /**
     * hystrix 全局fallback方法
     *
     * @return
     */
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }


}

