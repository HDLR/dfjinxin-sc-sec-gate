package com.dfjinxin.admin.feign;

import com.dfjinxin.common.exception.auth.FeignException;
import org.springframework.stereotype.Component;

@Component
public class TestFeignServiceFallback implements TestFeignService {

    public String test(){
        throw new FeignException("访问后台管理系统dfjinxin-admin异常");
    }
}
