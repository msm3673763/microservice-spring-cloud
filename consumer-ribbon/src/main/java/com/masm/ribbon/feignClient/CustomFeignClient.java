package com.masm.ribbon.feignClient;

import com.masm.config.FeignConfiguration;
import com.masm.ribbon.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "provider", configuration = FeignConfiguration.class)
public interface CustomFeignClient {

    @RequestMapping(value = "/queryUserById/{id}", method = RequestMethod.GET)
    public User queryUserById(@PathVariable("id") int id);
}
