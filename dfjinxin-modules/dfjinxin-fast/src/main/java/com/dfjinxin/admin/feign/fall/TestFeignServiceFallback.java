package com.dfjinxin.admin.feign.fall;

import com.dfjinxin.admin.feign.TestFeignService;
import com.dfjinxin.common.exception.auth.FeignException;
import com.dfjinxin.common.msg.ObjectRestResponse;
import com.dfjinxin.common.msg.R;
import feign.hystrix.FallbackFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class TestFeignServiceFallback implements FallbackFactory<TestFeignService> {

    public static final String ERR_MSG = "dfjinxin-test接口暂时不可用: ";
    @Override
    public TestFeignService create(Throwable throwable) {
        String msg = throwable == null ? "" : throwable.getMessage();
        if (!StringUtils.isEmpty(msg)) {
            System.out.println("异常msg================" + msg);
        }
        return new TestFeignService() {
            @Override
            public ObjectRestResponse test() {
//                return ERR_MSG + msg;
                ObjectRestResponse res = new ObjectRestResponse();
                res.setStatus(500);
                res.setMessage(ERR_MSG + msg);
                return res;
            }
        };
    }
}
