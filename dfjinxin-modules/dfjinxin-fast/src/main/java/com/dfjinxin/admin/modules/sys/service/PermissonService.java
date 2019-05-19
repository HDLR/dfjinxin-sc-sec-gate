/**
 * 2019 dfjinxin
 */

package com.dfjinxin.admin.modules.sys.service;

import com.dfjinxin.common.vo.PermissionInfo;

import java.util.List;
import java.util.Set;

public interface PermissonService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    List<PermissionInfo> permissonByUserId(long userId);

    List<PermissionInfo> allPermisson();

}
