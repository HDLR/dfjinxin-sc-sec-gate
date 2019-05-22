package com.dfjinxin.test.test;

import com.dfjinxin.common.msg.ObjectRestResponse;
import com.dfjinxin.common.msg.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public ObjectRestResponse test(){
        ObjectRestResponse res = new ObjectRestResponse();
        res.setMessage("请求成功");
        return res;
    }

}
