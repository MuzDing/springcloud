package com.muzdin.springcloud.control;

import com.muzding.springcloud.entity.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderConsulControl {

    public static final String url = "http://consul-provider-payment";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/consul/createPay",method = RequestMethod.POST)
    public CommonResult create (@RequestParam String id, @RequestParam String serial){
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("id",id);
        map.add("serial",serial);
        System.out.println(map.toString());
        return restTemplate.postForObject(url + "/createPay",map,CommonResult.class);
    }


    @RequestMapping(value = "/consumer/consul",method = RequestMethod.GET)
    public String payInfo (){
        return restTemplate.getForObject(url + "/consul" ,String.class);
    }

    // 通过生产者 消费者模型调用
    @RequestMapping(value = "/consumer/consul/discovery",method = RequestMethod.GET)
    public CommonResult discovery (){
        return restTemplate.getForObject(url + "/discovery" ,CommonResult.class);
    }
}
