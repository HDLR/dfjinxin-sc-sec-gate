package com.dfjinxin.auth.client.feign;

import com.dfjinxin.auth.client.feign.fall.AdminServiceFeignFall;
import com.dfjinxin.common.vo.PermissionInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@FeignClient(value = "${admin.application.name}",fallback = AdminServiceFeignFall.class)
public interface AdminServiceFeign {

    @RequestMapping(value = "/api/all/permisson", method = RequestMethod.POST)
    public List<PermissionInfo> allPermisson();

    @RequestMapping(value = "/api/user/permisson", method = RequestMethod.POST)
    public List<PermissionInfo> permisson(@RequestParam("userId") String userId);

}
