package com.muzding.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_OK,id " + id +"\t" + "哈哈";
    }

    public String paymentInfo_Timeout(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (Exception e){
            e.printStackTrace();
        }
                
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_OK,id " + id +"\t" + "哈哈, 耗时3秒";
    }
}
