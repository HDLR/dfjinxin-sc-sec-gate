package com.dfjinxin.admin.modules.auth.service.impl;

import com.dfjinxin.admin.common.utils.EncoderUtils;
import com.dfjinxin.admin.modules.auth.service.AuthService;
import com.dfjinxin.admin.modules.auth.utils.JwtTokenUtil;
import com.dfjinxin.auth.common.util.jwt.JWTInfo;
import com.dfjinxin.auth.common.util.jwt.JwtAuthenticationRequest;
import com.dfjinxin.common.constant.RedisConstants;
import com.dfjinxin.common.exception.auth.UserInvalidException;
import com.dfjinxin.admin.common.utils.EncoderUtils;
import com.dfjinxin.admin.modules.auth.service.AuthService;
import com.dfjinxin.admin.modules.auth.utils.JwtTokenUtil;
import com.dfjinxin.admin.modules.sys.entity.SysUserEntity;
import com.dfjinxin.admin.modules.sys.service.SysUserService;
import com.dfjinxin.common.vo.PermissionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public String userAuth(JwtAuthenticationRequest authReq){
        //用户信息
        SysUserEntity user = sysUserService.queryByUserName(authReq.getUsername());

        //账号不存在、密码错误
        if(user == null || !(EncoderUtils.getInstance().matches(authReq.getPassword(), user.getPassword()))) {
            throw new UserInvalidException("用户不存在或账户密码错误!");
        }

        //账号锁定
        if(user.getStatus() == 0){
            throw new UserInvalidException("账号已被锁定!");
        }

        String token = null;
        try {
            token = jwtTokenUtil.generateToken(new JWTInfo(user.getUsername(), "" + user.getUserId(), user.getUsername()));
        }catch (Exception e){
            throw new UserInvalidException("token生成异常!");
        }

        //验证成功后清除原先redis的权限缓存
        redisTemplate.delete(RedisConstants.USER_PERMISSION + "::" + user.getUserId());
        redisTemplate.delete(RedisConstants.ALL_PERMISSION + "::" + user.getUserId());

        return token;
    }
}
