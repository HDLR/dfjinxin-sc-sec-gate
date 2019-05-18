/**
 * 2019 dfjinxin
 *
 *
 *
 *
 */

package com.dfjinxin.admin.modules.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dfjinxin.admin.common.utils.PageUtils;
import com.dfjinxin.admin.modules.oss.entity.SysOssEntity;
import com.dfjinxin.admin.common.utils.PageUtils;
import com.dfjinxin.admin.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
