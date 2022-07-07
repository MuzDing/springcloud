package com.muzding.springcloud.control;

import com.muzding.springcloud.entity.Payment;
import com.muzding.springcloud.service.PaymentService;
import com.muzding.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentControl {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/createPay",method = RequestMethod.POST)
    public CommonResult createPay(@RequestParam String id , @RequestParam String serial){
        System.out.println(id + serial);
        Payment payMent = new Payment(Long.parseLong(id),serial);
        paymentService.insertPayment(payMent);

        return new CommonResult(1,"插入数据库成功",null);
    }

    @RequestMapping(value = "/fingPaymentByid",method = RequestMethod.GET)
    public CommonResult fingPaymentByid(@RequestParam Long id){
        log.info("查询成功");
        return new CommonResult(1,"查询成功",paymentService.fingPaymentByid(id));
    }


    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String createPay1(@RequestParam String serial){
        return serial;
    }
}
