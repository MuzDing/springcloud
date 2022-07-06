package com.liding.springcloud.control;

import com.liding.springcloud.entity.CommonResult;
import com.liding.springcloud.entity.Payment;
import com.liding.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class PaymentControl {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/createPay",method = RequestMethod.POST)
    public CommonResult createPay(@RequestParam Long id ,@RequestParam String serial){
        Payment payMent = new Payment(id,serial);
        paymentService.insertPayment(payMent);

        return new CommonResult(1,"1",null);
    }

    @RequestMapping(value = "/fingPaymentByid",method = RequestMethod.POST)
    public CommonResult fingPaymentByid(@RequestParam Long id){
        log.info("查询成功");
        return new CommonResult(1,"1",paymentService.fingPaymentByid(id));
    }


    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String createPay1(@RequestParam String serial){
        return serial;
    }
}
