package com.dfjinxin.common.handler;

import com.dfjinxin.common.exception.auth.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ExceptinErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        Exception exception = null;
        try {
            // 获取原始的返回内容
            String json = Util.toString(response.body().asReader());
            exception = new FeignException(json);
            // 将返回内容反序列化为Result，这里应根据自身项目作修改
//            Result result = JsonMapper.nonEmptyMapper().fromJson(json, Result.class);
//            // 业务异常抛出简单的 RuntimeException，保留原来错误信息
//            if (!result.isSuccess()) {
//                exception = new RuntimeException(result.getMessage());
//            }
        } catch (IOException ex) {
//            logger.error(ex.getMessage(), ex);
        }
        return exception;
    }
}