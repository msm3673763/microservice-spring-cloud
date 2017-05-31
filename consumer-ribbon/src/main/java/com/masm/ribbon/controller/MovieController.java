package com.masm.ribbon.controller;

import com.masm.ribbon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by simple on 2017/5/29.
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${user.path}")
    private String path;

    @GetMapping("/test")
    public String test() {
        ServiceInstance instance = loadBalancerClient.choose("provider");
        System.out.println("服务一：" + instance.getHost() + ":" + instance.getPort() + ":" + instance.getServiceId());

        ServiceInstance instance1 = loadBalancerClient.choose("provider2");
        System.out.println("服务二：" + instance1.getHost() + ":" + instance1.getPort() + ":" + instance1.getServiceId());
        return "1";
    }

    /**
     * @Description: 测试通过配置文件自定义策略
     * @param     id
     * @return    返回类型
     * @author ucs_masiming
     * @throws
     * @date 2017/5/31 10:49
     * @version V1.0
     */
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
        ServiceInstance instance = loadBalancerClient.choose("provider");
        System.out.println("服务：" + instance.getServiceId() + ":" + instance.getHost() + ":" + instance.getPort());
        return restTemplate.getForObject(path + id, User.class);
    }

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable int id) {
        //return restTemplate.getForObject("http://localhost:7900/findById/" + id, User.class);
        return restTemplate.getForObject("http://provider/findById/" + id, User.class);
    }
}
