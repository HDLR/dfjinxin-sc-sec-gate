/**
 * 2019 dfjinxin
 *
 *
 *
 *
 */

package com.dfjinxin.admin.modules.sys.service.impl;

import com.dfjinxin.admin.common.utils.Constant;
import com.dfjinxin.admin.modules.sys.dao.SysMenuDao;
import com.dfjinxin.admin.modules.sys.dao.SysUserDao;
import com.dfjinxin.admin.modules.sys.entity.SysMenuEntity;
import com.dfjinxin.common.constant.RedisConstants;
import com.dfjinxin.admin.modules.sys.service.PermissonService;
import com.dfjinxin.common.vo.PermissionInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PermissonServiceImpl implements PermissonService {
    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            List<SysMenuEntity> menuList = sysMenuDao.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for(SysMenuEntity menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = sysUserDao.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public List<PermissionInfo> permissonByUserId(long userId){
        List<PermissionInfo> permissionInfos;
        List<SysMenuEntity> menuList;
        //系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            menuList = sysMenuDao.selectList(null);
        }else{
            menuList = sysUserDao.queryAllSysUserEntity(userId);
        }

        //用户权限列表
        return this.getPermissionInfos(menuList);
    }

    @Override
    public List<PermissionInfo> allPermisson(){
        List<PermissionInfo> permissionInfos;
        List<SysMenuEntity> menuList = sysMenuDao.selectList(null);

        //用户权限列表
        return this.getPermissionInfos(menuList);
    }

    private List<PermissionInfo> getPermissionInfos(List<SysMenuEntity> menuList){
        int size = menuList.size();
        if(size > 0){
            List<PermissionInfo> permissionInfos = new ArrayList<PermissionInfo>();
            for(SysMenuEntity menu : menuList){
                if(null != menu){
                    String url = menu.getUrl();
                    if(StringUtils.isNotBlank(url)){
                        url = url.replaceAll(" ", "").replaceAll("，", ",");
                        List<String> urls = new ArrayList<String>();
                        if(url.contains(",")){
                            for(String v : url.split(",")){
                                urls.add(v);
                            }
                        }else{
                            urls.add(url);
                        }

                        for(String v : urls){
                            PermissionInfo info = new PermissionInfo();
                            info.setCode(menu.getPerms());
                            info.setType(menu.getType());
                            info.setUri(v);
                            info.setMethod(menu.getMethod());
                            info.setName(menu.getName());
                            permissionInfos.add(info);
                        }
                    }
                }
            }
            return permissionInfos;
        }
        return new ArrayList<PermissionInfo>();
    }
}
