package com.dfjinxin.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZDL
 */
@Data
public class PermissionInfo implements Serializable{
    private String code;
    private Integer type;
    private String uri;
    private String method;
    private String name;
}
