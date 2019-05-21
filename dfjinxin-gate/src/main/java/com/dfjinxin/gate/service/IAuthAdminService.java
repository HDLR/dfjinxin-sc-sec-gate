package com.dfjinxin.gate.service;

import com.dfjinxin.common.vo.PermissionInfo;

import java.util.List;

public interface IAuthAdminService {

    List<PermissionInfo> permissonByUserId(String userId);

    List<PermissionInfo> allPermisson(String userId);
}
