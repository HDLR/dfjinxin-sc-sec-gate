package com.dfjinxin.common.handler;

import com.dfjinxin.common.exception.BaseException;
import com.dfjinxin.common.exception.auth.*;
import com.dfjinxin.common.msg.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.dfjinxin")
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ClientTokenException.class)
    public R clientTokenExceptionHandler(ClientTokenException ex) {
        logger.error(ex.getMessage(),ex);
        return R.error(403, ex.getMessage());
    }

    @ExceptionHandler(UserTokenException.class)
    public R userTokenExceptionHandler(UserTokenException ex) {
        logger.error(ex.getMessage(),ex);
        return R.error(200, ex.getMessage());
    }

    @ExceptionHandler(UserInvalidException.class)
    public R userInvalidExceptionHandler(UserInvalidException ex) {
        logger.error(ex.getMessage(),ex);
        return R.error(200, ex.getMessage());
    }

    @ExceptionHandler(BaseException.class)
    public R baseExceptionHandler(BaseException ex) {
        logger.error(ex.getMessage(),ex);
        return R.error(500, ex.getMessage());
    }

    @ExceptionHandler(AuthorizationException.class)
    public R authorizationExceptionHandler(AuthorizationException ex) {
        return R.error(500, "无此操作的权限，请联系管理员。");
    }

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(RRException.class)
    public R handleRRException(RRException e){
        R r = new R();
        r.put("code", e.getCode());
        r.put("msg", e.getMessage());

        return r;
    }

    @ExceptionHandler(FeignException.class)
    public R handleFeignException(FeignException e){
        return R.error(500, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e){
        logger.error(e.getMessage(), e);
        if(null != e.getMessage()){
            return R.error(e.getMessage());
        }
        return R.error();
    }

}
