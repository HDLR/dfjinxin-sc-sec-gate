package com.dfjinxin.auth.client.feign.fall;

import com.dfjinxin.auth.client.feign.AdminServiceFeign;
import com.dfjinxin.common.exception.auth.FeignException;
import com.dfjinxin.common.vo.PermissionInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class AdminServiceFeignFall implements AdminServiceFeign {

    @Override
    public List<PermissionInfo> allPermisson(){
        throw new FeignException("访问后台管理系统dfjinxin-admin异常");
    }

    @Override
    public List<PermissionInfo> permisson(String userId){
        throw new FeignException("访问后台管理系统dfjinxin-admin异常");
    }
}
