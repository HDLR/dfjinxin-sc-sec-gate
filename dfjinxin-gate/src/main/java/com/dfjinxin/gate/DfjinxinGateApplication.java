package com.dfjinxin.gate;

import com.dfjinxin.auth.client.EnableDfjinxinAuthClient;
import com.dfjinxin.cache.EnabledfjinxinCache;
import com.dfjinxin.common.EnableDfjinxinCommon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableDfjinxinAuthClient
@EnableFeignClients({"com.dfjinxin.auth.client.feign","com.dfjinxin.gate.feign"})
@EnabledfjinxinCache
@EnableDfjinxinCommon
@EnableAutoConfiguration
public class DfjinxinGateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DfjinxinGateApplication.class, args);
    }

}
