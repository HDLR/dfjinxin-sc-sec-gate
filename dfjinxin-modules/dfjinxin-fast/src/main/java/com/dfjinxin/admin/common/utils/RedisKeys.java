/**
 * 2019 dfjinxin
 *
 *
 *
 *
 */

package com.dfjinxin.admin.common.utils;

/**
 * Redis所有Keys
 *
 * @author Mark sunlightcs@gmail.com
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }
}
