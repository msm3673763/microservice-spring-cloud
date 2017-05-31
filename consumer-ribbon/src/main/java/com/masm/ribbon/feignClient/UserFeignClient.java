package com.masm.ribbon.feignClient;

import com.masm.ribbon.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("provider")
public interface UserFeignClient {

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") int id);

}
