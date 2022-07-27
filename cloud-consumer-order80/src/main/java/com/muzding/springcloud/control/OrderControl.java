package com.muzding.springcloud.control;

import com.muzding.springcloud.config.LoadBalancerConfig;
import com.muzding.springcloud.entity.CommonResult;
import com.muzding.springcloud.lib.MyLoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
//@LoadBalancerClient(name = "CLOUD-PAYMENT-SERVICE",configuration = LoadBalancerConfig.class)
public class OrderControl {

    public static final String url = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/createPay",method = RequestMethod.POST)
    public CommonResult createPay (@RequestParam String id, @RequestParam String serial){
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("id",id);
        map.add("serial",serial);
        System.out.println(map.toString());
        return restTemplate.postForObject(url + "/createPay",map,CommonResult.class);
    }

    @RequestMapping(value = "/consumer/post/createPay",method = RequestMethod.POST)
    public CommonResult createPay1 (@RequestParam String id, @RequestParam String serial){
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("id",id);
        map.add("serial",serial);
        // 加入请求头 指定编码格式
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map,headers);
        return restTemplate.postForEntity(url + "/createPay",request,CommonResult.class).getBody();
    }


    @RequestMapping(value = "/consumer/fingPaymentByid",method = RequestMethod.GET)
    public CommonResult fingPaymentByid (@RequestParam Long id){
        return restTemplate.getForObject(url + "/fingPaymentByid?id="+ id,CommonResult.class);
    }

    @RequestMapping(value = "/consumer/get/fingPaymentByid",method = RequestMethod.GET)
    public CommonResult fingPaymentByid1 (@RequestParam Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(url + "/fingPaymentByid?id=" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }
        else {
            return new CommonResult(0,"faild",null);
        }

    }

    // 通过生产者 消费者模型调用
    @RequestMapping(value = "/consumer/discovery",method = RequestMethod.GET)
    public CommonResult discovery (){
        return restTemplate.getForObject(url + "/discovery" ,CommonResult.class);
    }


    @Resource
    private DiscoveryClient discoveryClient;
    @Autowired
    private MyLoadBalancer myLoadBalancer;

    /**
     * @author lixiaolong
     * @date 2020/12/23 10:27
     * @description 测试自定义的负载均衡规则
     */
    @RequestMapping(value = "/consumer/mybalancer", method = RequestMethod.GET)
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances == null || instances.isEmpty()) {
            return null;
        }

        // 调用自定义的负载均衡策略
        ServiceInstance serviceInstance = myLoadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/discovery", String.class);

    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin(){
        return restTemplate.getForObject(  "http://localhost:8001/payment/zipkin",String.class);
    }


}
