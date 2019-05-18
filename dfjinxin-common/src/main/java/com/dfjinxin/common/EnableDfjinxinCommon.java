package com.dfjinxin.common;

import com.dfjinxin.common.config.CommonConfig;
import org.springframework.context.annotation.Import;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(CommonConfig.class)
@Documented
@Inherited
public @interface EnableDfjinxinCommon {

}
