package com.masm.ribbon.feignClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "eurekaFeignClient", url = "http://localhost:8761")
public interface EurekaFeignClient {

    @RequestMapping(value = "/eureka/apps/{serverName}", method = RequestMethod.GET)
    public String getServerInfo(@PathVariable("serverName") String serverName);
}
