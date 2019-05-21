package com.dfjinxin.admin.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "dfjinxin-test",fallback = TestFeignServiceFallback.class)
public interface TestFeignService {

    @RequestMapping(value="/test",method = RequestMethod.GET)
    public String test();
}
