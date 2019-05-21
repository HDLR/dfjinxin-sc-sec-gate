package com.dfjinxin.gate.service;

import com.dfjinxin.auth.client.feign.AdminServiceFeign;
import com.dfjinxin.common.constant.RedisConstants;
import com.dfjinxin.common.vo.PermissionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthAdminService implements IAuthAdminService{

    @Autowired
    private AdminServiceFeign adminServiceFeign;

    @Cacheable(value = RedisConstants.USER_PERMISSION, key = "#userId")
    @Override
    public List<PermissionInfo> permissonByUserId(String userId){
        return adminServiceFeign.permisson(userId);
    }

    @Cacheable(value = RedisConstants.ALL_PERMISSION, key = "#userId")
    @Override
    public List<PermissionInfo> allPermisson(String userId){
        return adminServiceFeign.allPermisson();
    }

}
