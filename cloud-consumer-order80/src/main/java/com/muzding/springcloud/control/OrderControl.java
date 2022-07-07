package com.muzding.springcloud.control;

import com.muzding.springcloud.entity.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderControl {

    public static final String url = "http://192.168.101.12:8001";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/createPay",method = RequestMethod.POST)
    public CommonResult create (@RequestParam String id, @RequestParam String serial){
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("id",id);
        map.add("serial",serial);
        System.out.println(map.toString());
        return restTemplate.postForObject(url + "/createPay",map,CommonResult.class);
    }


    @RequestMapping(value = "/consumer/fingPaymentByid",method = RequestMethod.GET)
    public CommonResult create (@RequestParam Long id){
        return restTemplate.getForObject(url + "/fingPaymentByid?id="+ id,CommonResult.class);
    }
}
