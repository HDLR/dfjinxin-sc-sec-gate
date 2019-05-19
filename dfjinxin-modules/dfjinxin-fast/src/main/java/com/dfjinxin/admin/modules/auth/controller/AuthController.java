package com.dfjinxin.admin.modules.auth.controller;

import com.dfjinxin.admin.common.annotation.IgnoreResponseAdvice;
import com.dfjinxin.admin.modules.auth.service.AuthService;
import com.dfjinxin.admin.modules.sys.controller.AbstractController;
import com.dfjinxin.auth.client.annotation.IgnoreUserToken;
import com.dfjinxin.auth.common.util.jwt.JwtAuthenticationRequest;
import com.dfjinxin.common.msg.R;
import com.dfjinxin.admin.modules.sys.service.PermissonService;
import com.dfjinxin.common.vo.PermissionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
public class AuthController extends AbstractController {

    @Autowired
    private PermissonService permissonService;
    @Autowired
    private AuthService authService;

    /**
     * 登录
     */
    @IgnoreUserToken
    @PostMapping("/sys/jwt/token")
    public R login(@RequestBody JwtAuthenticationRequest authReq){

//		boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
//		if(!captcha){
//			return R.error("验证码不正确");
//		}

        String token = authService.userAuth(authReq);

        return R.ok().put("token", token);
    }

    /**
     * 获得所有权限
     */
    @IgnoreUserToken
    @IgnoreResponseAdvice
    @PostMapping("/api/all/permisson")
    public List<PermissionInfo> allPermisson()throws IOException {
        return permissonService.allPermisson();
    }

    /**
     * 获得登录用户的权限
     */
    @IgnoreUserToken
    @IgnoreResponseAdvice
    @PostMapping("/api/user/permisson")
    public List<PermissionInfo> permisson(@RequestParam("userId") String userId)throws IOException {
        return permissonService.permissonByUserId(Long.valueOf(userId));
    }
}
