package com.dfjinxin.admin.feign;

import com.dfjinxin.common.msg.ObjectRestResponse;
import com.dfjinxin.common.msg.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(value = "dfjinxin-test",fallback = TestFeignServiceFallback.class)
@FeignClient(value = "dfjinxin-test",fallbackFactory = TestFeignServiceFallback.class)
public interface TestFeignService {

    @RequestMapping(value="/test1",method = RequestMethod.GET)
    public ObjectRestResponse<String> test();
}
