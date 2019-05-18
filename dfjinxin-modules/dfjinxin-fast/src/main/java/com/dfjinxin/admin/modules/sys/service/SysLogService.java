/**
 * 2019 dfjinxin
 *
 *
 *
 *
 */

package com.dfjinxin.admin.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dfjinxin.admin.common.utils.PageUtils;
import com.dfjinxin.admin.modules.sys.entity.SysLogEntity;
import com.dfjinxin.admin.common.utils.PageUtils;
import com.dfjinxin.admin.modules.sys.entity.SysLogEntity;
import com.dfjinxin.admin.common.utils.PageUtils;
import com.dfjinxin.admin.modules.sys.entity.SysLogEntity;

import java.util.Map;


/**
 * 系统日志
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
