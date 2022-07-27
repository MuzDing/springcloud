package com.muzding.springcloud.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitControl {

    @GetMapping("/testA")
    public String testA(){
        // 测试阈值类型：线程数
//        try {
//            TimeUnit.MILLISECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------testD";
    }

}
